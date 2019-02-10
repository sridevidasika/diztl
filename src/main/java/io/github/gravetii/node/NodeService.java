package io.github.gravetii.node;

import com.google.protobuf.ByteString;
import io.github.gravetii.common.DiztilUtils;
import io.github.gravetii.generated.DiztilPojo;
import io.github.gravetii.generated.DiztilServiceGrpc;
import io.github.gravetii.node.indexer.BasicFileIndexer;
import io.grpc.stub.StreamObserver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

class NodeService extends DiztilServiceGrpc.DiztilServiceImplBase {
  private static final Logger logger =
      LoggerFactory.getLogger(NodeService.class.getCanonicalName());

  private static final int BUFFER_SIZE = 1024 * 1024;

  private BasicFileIndexer fileIndexer;

  NodeService() {
    this.fileIndexer = BasicFileIndexer.newDefaultIndexer();
  }

  @Override
  public void search(
      DiztilPojo.SearchRequest request,
      StreamObserver<DiztilPojo.SearchResponse> responseObserver) {
    List<DiztilPojo.FileMetadata> files = fileIndexer.search(request.getFilename());
    DiztilPojo.SearchResponse response =
        DiztilPojo.SearchResponse.newBuilder().setCount(files.size()).addAllFiles(files).build();
    responseObserver.onNext(response);
    responseObserver.onCompleted();
  }

  @Override
  public void upload(
      DiztilPojo.DownloadRequest request, StreamObserver<DiztilPojo.File> responseObserver) {
    logger.info("Uploading file for request {}", request);
    BufferedInputStream stream = null;
    String filename = request.getMetadata().getName();
    final String inputFilePath = DiztilUtils.DEFAULT_SHARE_PATH + filename;
    logger.info("Final input file path - {}", inputFilePath);
    try {
      File file = new File(inputFilePath);
      if (!file.exists()) {
        logger.info("Specified file does not exist.");
        return;
      }

      stream = new BufferedInputStream(new FileInputStream(file));
      byte[] buffer = new byte[BUFFER_SIZE];
      int chunk = 1;
      while ((stream.read(buffer)) > 0) {
        ByteString bytes = ByteString.copyFrom(buffer);
        DiztilPojo.FileMetadata metadata =
            DiztilPojo.FileMetadata.newBuilder().setName(file.getName()).build();
        DiztilPojo.File fileChunk =
            DiztilPojo.File.newBuilder()
                .setMetadata(metadata)
                .setData(bytes)
                .setChunk(chunk++)
                .build();
        responseObserver.onNext(fileChunk);
      }
    } catch (IOException e) {
      logger.error("Error while uploading file", e);
    } finally {
      responseObserver.onCompleted();
      if (stream != null) {
        try {
          stream.close();
        } catch (IOException e) {
          logger.error("Error while closing input stream", e);
        }
      }
    }
  }
}
