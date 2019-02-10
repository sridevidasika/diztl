package io.github.gravetii.common;

import io.github.gravetii.config.DiztilConfig;
import io.github.gravetii.generated.DiztilPojo;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

public class DiztilConnection {
  private static final Logger logger =
      LoggerFactory.getLogger(DiztilConnection.class.getCanonicalName());

  private static final DiztilConfig config = new DiztilConfig();
  private static final Map<String, NodeConnection> connections = new HashMap<>();

  public static NodeConnection get(DiztilPojo.Node node) {
    return connections.getOrDefault(node.getIp(), create(node));
  }

  private static NodeConnection create(DiztilPojo.Node node) {
    ManagedChannel channel =
        ManagedChannelBuilder.forAddress(node.getIp(), config.getNodePort()).usePlaintext().build();
    NodeConnection connection = new NodeConnection(channel);
    connections.put(node.getIp(), connection);
    logger.debug("Created new connection to {}", node);
    return connection;
  }
}
