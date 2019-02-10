package io.github.gravetii.tracker;

import io.github.gravetii.generated.DiztilPojo;
import io.github.gravetii.generated.TrackerServiceGrpc;
import io.grpc.stub.StreamObserver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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

  }

}
