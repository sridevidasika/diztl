package io.github.gravetii.common;

import io.github.gravetii.generated.DiztlServiceGrpc;
import io.grpc.ManagedChannel;

public class NodeConnection {
  private ManagedChannel channel;
  private DiztlServiceGrpc.DiztlServiceBlockingStub stub;
  private DiztlServiceGrpc.DiztlServiceStub asyncStub;

  public NodeConnection(ManagedChannel channel) {
    this.channel = channel;
    this.stub = DiztlServiceGrpc.newBlockingStub(channel);
    this.asyncStub = DiztlServiceGrpc.newStub(channel);
  }

  public ManagedChannel getChannel() {
    return channel;
  }

  public DiztlServiceGrpc.DiztlServiceBlockingStub getStub() {
    return stub;
  }

  public DiztlServiceGrpc.DiztlServiceStub getAsyncstub() {
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
