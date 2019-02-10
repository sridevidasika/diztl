package io.github.gravetii.common;

import java.net.InetSocketAddress;
import java.net.Socket;

public class DiztilUtils {
  public static final String DEFAULT_SHARE_PATH =
      "/Users/" + System.getProperty("user.name") + "/" + "Documents/diztil/share";

  public static String getMyIP() {
    try {
      Socket socket = new Socket();
      socket.connect(new InetSocketAddress("google.com", 80));
      return socket.getLocalAddress().getHostAddress();
    } catch (Exception e) {
      return null;
    }
  }

  public static void main(String[] args) {
    String ip = getMyIP();
    System.out.println(ip);
  }
}
