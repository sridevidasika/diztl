package io.github.gravetii.node;

import io.github.gravetii.common.DiztilConnection;
import io.github.gravetii.common.DiztilUtils;
import io.github.gravetii.common.NodeConnection;
import io.github.gravetii.common.TrackerConnection;
import io.github.gravetii.generated.DiztilPojo;
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

  private DiztilPojo.Node myNode;
  private TrackerConnection connection;
  private DiztilConnection diztilConnection;

  public NodeClient(String host, int port) {
    ManagedChannel channel = ManagedChannelBuilder.forAddress(host, port).usePlaintext().build();
    this.connection = new TrackerConnection(channel);
    this.diztilConnection = new DiztilConnection();
  }

  public void register() {
    try {
      String ip = DiztilUtils.getMyIP();
      DiztilPojo.Node node = DiztilPojo.Node.newBuilder().setIp(ip).build();
      myNode = connection.getStub().register(node);
      logger.info("Node registered to tracker - {}", myNode);
    } catch (Exception e) {
      logger.error("Error while registering node to tracker", e);
      System.exit(1);
    }
  }

  public List<DiztilPojo.SearchResponse> search(String pattern) {
    logger.info("Searching for pattern {}", pattern);
    List<DiztilPojo.SearchResponse> result = new ArrayList<>();
    DiztilPojo.SearchRequest request = DiztilPojo.SearchRequest.newBuilder()
            .setFilename(pattern).setSource(myNode).build();
    Iterator<DiztilPojo.SearchResponse> itr = connection.getStub().search(request);
    while (itr.hasNext()) {
      result.add(itr.next());
    }

    return result;
  }

  public void download(DiztilPojo.DownloadRequest request) {
    DiztilPojo.Node source = request.getSource();
    NodeConnection connection = diztilConnection.get(source);

    StreamObserver<DiztilPojo.File> responseObserver = new StreamObserver<DiztilPojo.File>() {
      BufferedOutputStream stream = null;
      @Override
      public void onNext(DiztilPojo.File file) {
        byte[] data = file.getData().toByteArray();
        final String outputFilePath = DiztilUtils.DEFAULT_SHARE_PATH + file.getMetadata().getName();
        if (file.getChunk() == 1) {
          try {
            stream = new BufferedOutputStream(new FileOutputStream(outputFilePath));
          }
          catch (IOException e) {
            logger.error("Error while initialising output stream", e);
          }
        }

        try {
          stream.write(data);
        }
        catch (IOException e) {
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
        }
        catch (IOException e) {
          logger.error("Error while closing output stream", e);
        }
      }
    };

    connection.getAsyncstub().upload(request, responseObserver);
  }
}
