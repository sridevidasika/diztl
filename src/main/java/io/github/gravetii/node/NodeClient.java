package io.github.gravetii.node;

import io.github.gravetii.common.DiztilUtils;
import io.github.gravetii.common.TrackerConnection;
import io.github.gravetii.generated.DiztilPojo;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class NodeClient {
  private static final Logger logger = LoggerFactory.getLogger(NodeClient.class.getCanonicalName());

  private DiztilPojo.Node myNode;
  private TrackerConnection connection;

  public NodeClient(String host, int port) {
    this(ManagedChannelBuilder.forAddress(host, port).usePlaintext().build());
  }

  private NodeClient(ManagedChannel channel) {
    this.connection = new TrackerConnection(channel);
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
}
