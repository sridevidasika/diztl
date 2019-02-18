package io.github.gravetii.tracker;

import io.github.gravetii.common.NodeConnection;
import io.github.gravetii.config.DiztlConfig;
import io.github.gravetii.generated.DiztlPojo;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

class NodeKeeper {
  private static final Logger logger = LoggerFactory.getLogger(NodeKeeper.class.getCanonicalName());

  private DiztlConfig config = new DiztlConfig();

  private AtomicInteger count;
  private Map<String, DiztlPojo.Node> activeNodes;
  private Map<String, NodeConnection> activeConnections;

  NodeKeeper() {
    this.count = new AtomicInteger(0);
    this.activeNodes = new ConcurrentHashMap<>();
    this.activeConnections = new ConcurrentHashMap<>();
  }

  DiztlPojo.Node register(DiztlPojo.Node node) {
    int nodeId = count.incrementAndGet();
    String nodeIp = node.getIp();
    DiztlPojo.Node registeredNode =
        DiztlPojo.Node.newBuilder().setId(nodeId).setIp(nodeIp).build();
    activeNodes.put(nodeIp, registeredNode);
    return registeredNode;
  }

  List<DiztlPojo.Node> getActiveNodes() {
    return new ArrayList<>(activeNodes.values());
  }

  NodeConnection getConnection(DiztlPojo.Node node) {
    return activeConnections.getOrDefault(node.getIp(), createConnection(node));
  }

  private NodeConnection createConnection(DiztlPojo.Node node) {
    ManagedChannel channel =
        ManagedChannelBuilder.forAddress(node.getIp(), config.getNodePort()).usePlaintext().build();
    NodeConnection connection = new NodeConnection(channel);
    logger.info("Created connection to node {} - {}", node, connection);
    activeConnections.put(node.getIp(), connection);
    return connection;
  }
}
