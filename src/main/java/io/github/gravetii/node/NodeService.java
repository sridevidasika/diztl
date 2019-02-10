package io.github.gravetii.node;

import io.github.gravetii.generated.DiztilPojo;
import io.github.gravetii.generated.DiztilServiceGrpc;
import io.grpc.stub.StreamObserver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

class NodeService extends DiztilServiceGrpc.DiztilServiceImplBase {
  private static final Logger logger =
      LoggerFactory.getLogger(NodeService.class.getCanonicalName());

  private static final int BUFFER_SIZE = 1024 * 1024;

  private FileIndexer fileIndexer;

  NodeService() {
    this.fileIndexer = FileIndexer.newDefaultIndexer();
  }


  @Override
  public void search(DiztilPojo.SearchRequest request, StreamObserver<DiztilPojo.SearchResponse> responseObserver) {
    List<DiztilPojo.FileMetadata> files = fileIndexer.search(request.getFilename());
    DiztilPojo.SearchResponse response = DiztilPojo.SearchResponse.newBuilder()
            .setCount(files.size()).addAllFiles(files).build();
    responseObserver.onNext(response);
    responseObserver.onCompleted();
  }


}
