package io.github.gravetii.common;

import io.github.gravetii.generated.DiztilServiceGrpc;
import io.grpc.ManagedChannel;

import java.util.logging.Logger;

public class NodeConnection {
  private static final Logger logger = Logger.getLogger(NodeConnection.class.getCanonicalName());

  private ManagedChannel channel;
  private DiztilServiceGrpc.DiztilServiceBlockingStub stub;
  private DiztilServiceGrpc.DiztilServiceStub asyncStub;

  public NodeConnection(ManagedChannel channel) {
    this.channel = channel;
    this.stub = DiztilServiceGrpc.newBlockingStub(channel);
    this.asyncStub = DiztilServiceGrpc.newStub(channel);
  }

  public ManagedChannel getChannel() {
    return channel;
  }

  public DiztilServiceGrpc.DiztilServiceBlockingStub getStub() {
    return stub;
  }

  public DiztilServiceGrpc.DiztilServiceStub getAsyncstub() {
    return asyncStub;
  }

  @Override
  public String toString() {
    return "NodeConnection{"
        + "channel="
        + channel
        + ", stub="
        + stub
        + ", asyncStub="
        + asyncStub
        + '}';
  }
}
