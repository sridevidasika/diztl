package io.github.gravetii.tracker;

import io.github.gravetii.common.NodeConnection;
import io.github.gravetii.generated.DiztilPojo;
import io.github.gravetii.generated.TrackerServiceGrpc;
import io.grpc.stub.StreamObserver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

class TrackerService extends TrackerServiceGrpc.TrackerServiceImplBase {
  private static final Logger logger = LoggerFactory.getLogger(TrackerService.class.getCanonicalName());

  private NodeKeeper nodeKeeper;

  TrackerService() {
    this.nodeKeeper = new NodeKeeper();
  }

  @Override
  public void register(DiztilPojo.Node node, StreamObserver<DiztilPojo.Node> responseObserver) {
    DiztilPojo.Node registeredNode = nodeKeeper.register(node);
    responseObserver.onNext(registeredNode);
    responseObserver.onCompleted();
    logger.info("Successfully registered node - {}", node);
  }

  @Override
  public void search(DiztilPojo.SearchRequest request, StreamObserver<DiztilPojo.SearchResponse> responseObserver) {
    logger.info("Executing search request {}", request);
    List<DiztilPojo.SearchResponse> responses = broadcast(request);
    responses.forEach(responseObserver::onNext);
    responseObserver.onCompleted();
  }

  private List<DiztilPojo.SearchResponse> broadcast(DiztilPojo.SearchRequest request) {
    logger.info("Broadcasting search request to all active nodes - {}", request);
    List<DiztilPojo.SearchResponse> result = new ArrayList<>();

    for (DiztilPojo.Node node: nodeKeeper.getActiveNodes()) {
      if (node.getIp().equals(request.getSource().getIp())) {
        continue;
      }

      NodeConnection connection = nodeKeeper.getConnection(node);
      DiztilPojo.SearchResponse response = connection.getStub().search(request);
      if (response.getCount() > 0) {
        DiztilPojo.SearchResponse finalResponse =
                DiztilPojo.SearchResponse.newBuilder()
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
