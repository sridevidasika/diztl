package io.github.gravetii.node;

import com.google.protobuf.ByteString;
import io.github.gravetii.common.DiztlConnection;
import io.github.gravetii.common.DiztlUtils;
import io.github.gravetii.config.DiztlConfig;
import io.github.gravetii.generated.DiztlPojo;
import io.github.gravetii.generated.DiztlServiceGrpc;
import io.github.gravetii.node.indexer.BasicFileIndexer;
import io.grpc.stub.StreamObserver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

class NodeService extends DiztlServiceGrpc.DiztlServiceImplBase {
  private static final Logger logger =
      LoggerFactory.getLogger(NodeService.class.getCanonicalName());

  private static final int BUFFER_SIZE = 1024 * 1024;

  private DiztlConfig config = new DiztlConfig();

  private BasicFileIndexer fileIndexer;
  private NodeClient client;

  NodeService() {
    this.fileIndexer = BasicFileIndexer.newDefaultIndexer();
  }

  void bootstrap() {
    logger.info("Bootstrapping node now...");
    this.client = new NodeClient(config.getTrackerHost(), config.getTrackerPort());
    client.register();
  }

  @Override
  public void search(
      DiztlPojo.SearchRequest request,
      StreamObserver<DiztlPojo.SearchResponse> responseObserver) {
    List<DiztlPojo.FileMetadata> files = fileIndexer.search(request.getFilename());
    DiztlPojo.SearchResponse response =
        DiztlPojo.SearchResponse.newBuilder().setCount(files.size()).addAllFiles(files).build();
    responseObserver.onNext(response);
    responseObserver.onCompleted();
  }

  @Override
  public void upload(
      DiztlPojo.DownloadRequest request, StreamObserver<DiztlPojo.File> responseObserver) {
    logger.info("Uploading file for request {}", request);
    BufferedInputStream stream = null;
    String filename = request.getMetadata().getName();
    final String inputFilePath = DiztlUtils.DEFAULT_SHARE_PATH + filename;
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
        DiztlPojo.FileMetadata metadata =
            DiztlPojo.FileMetadata.newBuilder().setName(file.getName()).build();
        DiztlPojo.File fileChunk =
            DiztlPojo.File.newBuilder()
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
