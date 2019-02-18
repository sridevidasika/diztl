package io.github.gravetii.node;

import io.github.gravetii.generated.DiztlPojo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Scanner;

public class NodeCLI {

  private static final Logger logger = LoggerFactory.getLogger(NodeCLI.class.getCanonicalName());

  private NodeClient client;
  private Scanner scanner;

  public NodeCLI(NodeClient client) {
    this.scanner = new Scanner(System.in);
    this.client = client;
  }

  public void start() {
    while (true) {
      System.out.println("Enter a file name to search for: ");
      String filename = scanner.next();
      List<DiztlPojo.SearchResponse> responses = client.search(filename);
      logger.info("Search results for {} - {}", filename, responses);
    }
  }
}
