package io.github.gravetii.common;

import io.github.gravetii.generated.DiztilServiceGrpc;
import io.grpc.ManagedChannel;

public class NodeConnection {
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
