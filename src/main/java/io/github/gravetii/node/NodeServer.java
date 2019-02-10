package io.github.gravetii.node;

import io.github.gravetii.common.DiztilUtils;
import io.github.gravetii.config.DiztilConfig;
import io.github.gravetii.node.indexer.BasicFileIndexer;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class NodeServer {
  private static final Logger logger = LoggerFactory.getLogger(NodeServer.class.getCanonicalName());

  private DiztilConfig config;
  private Server server;
  private BasicFileIndexer fileIndexer;

  private NodeServer() {
    this.config = new DiztilConfig();
    String shareDir = DiztilUtils.DEFAULT_SHARE_PATH;
    this.fileIndexer = new BasicFileIndexer(shareDir);
  }

  private void start() throws IOException {
    int port = config.getNodePort();
    server = ServerBuilder.forPort(port).addService(new NodeService()).build().start();
    logger.info("Started node server on {}", port);
    Runtime.getRuntime()
        .addShutdownHook(
            new Thread(
                () -> {
                  NodeServer.this.stop();
                  logger.info("Successfully shut down node server.");
                }));
  }

  private void stop() {
    if (server != null) {
      server.shutdown();
    }
  }

  private void blockUntilShutdown() throws InterruptedException {
    if (server != null) {
      server.awaitTermination();
    }
  }

  public static void main(String[] args) throws Exception {
    NodeServer server = new NodeServer();
    server.start();
    server.blockUntilShutdown();
  }
}
