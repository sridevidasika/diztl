package io.github.gravetii.common;

import io.github.gravetii.config.DiztlConfig;
import io.github.gravetii.generated.DiztlPojo;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

public class DiztlConnection {
  private static final Logger logger =
      LoggerFactory.getLogger(DiztlConnection.class.getCanonicalName());

  private static final DiztlConfig config = new DiztlConfig();
  private static final Map<String, NodeConnection> connections = new HashMap<>();

  public static NodeConnection get(DiztlPojo.Node node) {
    return connections.getOrDefault(node.getIp(), create(node));
  }

  private static NodeConnection create(DiztlPojo.Node node) {
    ManagedChannel channel =
        ManagedChannelBuilder.forAddress(node.getIp(), config.getNodePort()).usePlaintext().build();
    NodeConnection connection = new NodeConnection(channel);
    connections.put(node.getIp(), connection);
    logger.debug("Created new connection to {}", node);
    return connection;
  }
}
