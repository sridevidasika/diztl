package io.github.gravetii.common;

import io.github.gravetii.generated.TrackerServiceGrpc;
import io.grpc.ManagedChannel;

public class TrackerConnection {
  private ManagedChannel channel;
  private TrackerServiceGrpc.TrackerServiceBlockingStub stub;
  private TrackerServiceGrpc.TrackerServiceStub asyncStub;

  public TrackerConnection(ManagedChannel channel) {
    this.channel = channel;
    this.stub = TrackerServiceGrpc.newBlockingStub(channel);
    this.asyncStub = TrackerServiceGrpc.newStub(channel);
  }

  public TrackerServiceGrpc.TrackerServiceBlockingStub getStub() {
    return stub;
  }

  public TrackerServiceGrpc.TrackerServiceStub getAsyncStub() {
    return asyncStub;
  }

  @Override
  public String toString() {
    return "TrackerConnection{" +
            "channel=" + channel +
            ", stub=" + stub +
            ", asyncStub=" + asyncStub +
            '}';
  }
}
