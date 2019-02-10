package io.github.gravetii.tracker;

import io.github.gravetii.config.DiztilConfig;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class TrackerServer {
  private static final Logger logger =
      LoggerFactory.getLogger(TrackerServer.class.getCanonicalName());

  private DiztilConfig config;
  private Server server;

  private TrackerServer() {
    this.config = new DiztilConfig();
  }

  private void start() throws IOException {
    int port = config.getTrackerPort();
    this.server = ServerBuilder.forPort(port).addService(new TrackerService()).build().start();
    logger.info("Started tracker server on port {}", port);

    Runtime.getRuntime()
        .addShutdownHook(
            new Thread(
                () -> {
                  TrackerServer.this.stop();
                  logger.info("Shut down tracker server.");
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
    TrackerServer server = new TrackerServer();
    server.start();
    server.blockUntilShutdown();
  }
}
