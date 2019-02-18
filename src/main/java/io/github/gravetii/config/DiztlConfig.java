package io.github.gravetii.config;

public class DiztlConfig {

  private static final ConfigReader READER = new ConfigReader();

  public String getTrackerHost() {
    return READER.getStringProperty("tracker_host");
  }

  public int getTrackerPort() {
    return READER.getIntegerProperty("tracker_port");
  }

  public int getNodePort() {
    return READER.getIntegerProperty("node_port");
  }

  public static void main(String[] args) {
    DiztlConfig config = new DiztlConfig();
    System.out.println(config.getTrackerPort());
  }
}
