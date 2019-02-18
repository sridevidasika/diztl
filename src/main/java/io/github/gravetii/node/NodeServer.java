package io.github.gravetii.node;

import io.github.gravetii.common.DiztlUtils;
import io.github.gravetii.config.DiztlConfig;
import io.github.gravetii.node.indexer.BasicFileIndexer;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class NodeServer {
  private static final Logger logger = LoggerFactory.getLogger(NodeServer.class.getCanonicalName());

  private DiztlConfig config = new DiztlConfig();
  private Server server;
  private NodeService impl;
  private BasicFileIndexer fileIndexer;

  private NodeServer() {
    String shareDir = DiztlUtils.DEFAULT_SHARE_PATH;
    this.impl = new NodeService();
    this.fileIndexer = new BasicFileIndexer(shareDir);
  }

  private void start() throws IOException {
    int port = config.getNodePort();
    server = ServerBuilder.forPort(port).addService(this.impl).build().start();
    logger.info("Started node server on {}", port);
    Runtime.getRuntime()
        .addShutdownHook(
            new Thread(
                () -> {
                  NodeServer.this.stop();
                  logger.info("Successfully shut down node server.");
                }));

    this.impl.bootstrap();
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
