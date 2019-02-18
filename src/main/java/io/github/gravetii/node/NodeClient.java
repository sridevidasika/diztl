package io.github.gravetii.node;

import io.github.gravetii.common.DiztlConnection;
import io.github.gravetii.common.DiztlUtils;
import io.github.gravetii.common.NodeConnection;
import io.github.gravetii.common.TrackerConnection;
import io.github.gravetii.generated.DiztlPojo;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class NodeClient {
  private static final Logger logger = LoggerFactory.getLogger(NodeClient.class.getCanonicalName());

  private DiztlPojo.Node node;
  private TrackerConnection connection;

  NodeClient(String host, int port) {
    ManagedChannel channel = ManagedChannelBuilder.forAddress(host, port).usePlaintext().build();
    this.connection = new TrackerConnection(channel);
  }

  void register() {
    String ip = DiztlUtils.getMyIP();
    DiztlPojo.Node node = DiztlPojo.Node.newBuilder().setIp(ip).build();
    this.node = connection.getStub().register(node);
    logger.info("Successfully registered node to tracker.");
  }

  public List<DiztlPojo.SearchResponse> search(String pattern) {
    logger.info("Searching for pattern {}", pattern);
    List<DiztlPojo.SearchResponse> result = new ArrayList<>();
    DiztlPojo.SearchRequest request =
        DiztlPojo.SearchRequest.newBuilder().setFilename(pattern).setSource(node).build();
    Iterator<DiztlPojo.SearchResponse> itr = connection.getStub().search(request);
    while (itr.hasNext()) {
      result.add(itr.next());
    }

    return result;
  }

  public void download(DiztlPojo.DownloadRequest request) {
    DiztlPojo.Node source = request.getSource();
    NodeConnection connection = DiztlConnection.get(source);

    StreamObserver<DiztlPojo.File> responseObserver =
        new StreamObserver<DiztlPojo.File>() {
          BufferedOutputStream stream = null;

          @Override
          public void onNext(DiztlPojo.File file) {
            byte[] data = file.getData().toByteArray();
            final String outputFilePath =
                DiztlUtils.DEFAULT_SHARE_PATH + file.getMetadata().getName();
            if (file.getChunk() == 1) {
              try {
                stream = new BufferedOutputStream(new FileOutputStream(outputFilePath));
              } catch (IOException e) {
                logger.error("Error while initialising output stream", e);
              }
            }

            try {
              stream.write(data);
            } catch (IOException e) {
              logger.error("Error while writing file data to output stream", e);
            }
          }

          @Override
          public void onError(Throwable throwable) {
            logger.error("Error while downloading file", throwable);
          }

          @Override
          public void onCompleted() {
            try {
              if (stream != null) {
                stream.flush();
                stream.close();
              }
            } catch (IOException e) {
              logger.error("Error while closing output stream", e);
            }
          }
        };

    connection.getAsyncstub().upload(request, responseObserver);
  }
}
