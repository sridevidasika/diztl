package io.github.gravetii.tracker;

import io.github.gravetii.common.NodeConnection;
import io.github.gravetii.generated.DiztlPojo;
import io.github.gravetii.generated.TrackerServiceGrpc;
import io.grpc.stub.StreamObserver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

class TrackerService extends TrackerServiceGrpc.TrackerServiceImplBase {
  private static final Logger logger =
      LoggerFactory.getLogger(TrackerService.class.getCanonicalName());

  private NodeKeeper nodeKeeper;

  TrackerService() {
    this.nodeKeeper = new NodeKeeper();
  }

  @Override
  public void register(DiztlPojo.Node node, StreamObserver<DiztlPojo.Node> responseObserver) {
    DiztlPojo.Node registeredNode = nodeKeeper.register(node);
    responseObserver.onNext(registeredNode);
    responseObserver.onCompleted();
    logger.info("Successfully registered node - {}", node);
  }

  @Override
  public void search(
      DiztlPojo.SearchRequest request,
      StreamObserver<DiztlPojo.SearchResponse> responseObserver) {
    logger.info("Executing search request {}", request);
    List<DiztlPojo.SearchResponse> responses = broadcast(request);
    responses.forEach(responseObserver::onNext);
    responseObserver.onCompleted();
  }

  private List<DiztlPojo.SearchResponse> broadcast(DiztlPojo.SearchRequest request) {
    logger.info("Broadcasting search request to all active nodes - {}", request);
    List<DiztlPojo.SearchResponse> result = new ArrayList<>();

    for (DiztlPojo.Node node : nodeKeeper.getActiveNodes()) {
//      if (node.getIp().equals(request.getSource().getIp())) {
//        continue;
//      }
      NodeConnection connection = nodeKeeper.getConnection(node);
      DiztlPojo.SearchResponse response = connection.getStub().search(request);
      if (response.getCount() > 0) {
        DiztlPojo.SearchResponse finalResponse =
            DiztlPojo.SearchResponse.newBuilder()
                .setCount(response.getCount())
                .addAllFiles(response.getFilesList())
                .setNode(node)
                .build();
        result.add(finalResponse);
      }
    }

    return result;
  }
}
