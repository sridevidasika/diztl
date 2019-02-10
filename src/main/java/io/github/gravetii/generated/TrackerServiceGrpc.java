package io.github.gravetii.generated;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.*;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.*;

/** */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.18.0)",
    comments = "Source: diztil.proto")
public final class TrackerServiceGrpc {

  private TrackerServiceGrpc() {}

  public static final String SERVICE_NAME = "io.github.gravetii.generated.TrackerService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          io.github.gravetii.generated.DiztilPojo.Node,
          io.github.gravetii.generated.DiztilPojo.Node>
      getRegisterMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "register",
      requestType = io.github.gravetii.generated.DiztilPojo.Node.class,
      responseType = io.github.gravetii.generated.DiztilPojo.Node.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          io.github.gravetii.generated.DiztilPojo.Node,
          io.github.gravetii.generated.DiztilPojo.Node>
      getRegisterMethod() {
    io.grpc.MethodDescriptor<
            io.github.gravetii.generated.DiztilPojo.Node,
            io.github.gravetii.generated.DiztilPojo.Node>
        getRegisterMethod;
    if ((getRegisterMethod = TrackerServiceGrpc.getRegisterMethod) == null) {
      synchronized (TrackerServiceGrpc.class) {
        if ((getRegisterMethod = TrackerServiceGrpc.getRegisterMethod) == null) {
          TrackerServiceGrpc.getRegisterMethod =
              getRegisterMethod =
                  io.grpc.MethodDescriptor
                      .<io.github.gravetii.generated.DiztilPojo.Node,
                          io.github.gravetii.generated.DiztilPojo.Node>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(
                              "io.github.gravetii.generated.TrackerService", "register"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              io.github.gravetii.generated.DiztilPojo.Node.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              io.github.gravetii.generated.DiztilPojo.Node.getDefaultInstance()))
                      .setSchemaDescriptor(new TrackerServiceMethodDescriptorSupplier("register"))
                      .build();
        }
      }
    }
    return getRegisterMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          io.github.gravetii.generated.DiztilPojo.SearchRequest,
          io.github.gravetii.generated.DiztilPojo.SearchResponse>
      getSearchMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "search",
      requestType = io.github.gravetii.generated.DiztilPojo.SearchRequest.class,
      responseType = io.github.gravetii.generated.DiztilPojo.SearchResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<
          io.github.gravetii.generated.DiztilPojo.SearchRequest,
          io.github.gravetii.generated.DiztilPojo.SearchResponse>
      getSearchMethod() {
    io.grpc.MethodDescriptor<
            io.github.gravetii.generated.DiztilPojo.SearchRequest,
            io.github.gravetii.generated.DiztilPojo.SearchResponse>
        getSearchMethod;
    if ((getSearchMethod = TrackerServiceGrpc.getSearchMethod) == null) {
      synchronized (TrackerServiceGrpc.class) {
        if ((getSearchMethod = TrackerServiceGrpc.getSearchMethod) == null) {
          TrackerServiceGrpc.getSearchMethod =
              getSearchMethod =
                  io.grpc.MethodDescriptor
                      .<io.github.gravetii.generated.DiztilPojo.SearchRequest,
                          io.github.gravetii.generated.DiztilPojo.SearchResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
                      .setFullMethodName(
                          generateFullMethodName(
                              "io.github.gravetii.generated.TrackerService", "search"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              io.github.gravetii.generated.DiztilPojo.SearchRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              io.github.gravetii.generated.DiztilPojo.SearchResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(new TrackerServiceMethodDescriptorSupplier("search"))
                      .build();
        }
      }
    }
    return getSearchMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static TrackerServiceStub newStub(io.grpc.Channel channel) {
    return new TrackerServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static TrackerServiceBlockingStub newBlockingStub(io.grpc.Channel channel) {
    return new TrackerServiceBlockingStub(channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static TrackerServiceFutureStub newFutureStub(io.grpc.Channel channel) {
    return new TrackerServiceFutureStub(channel);
  }

  /** */
  public abstract static class TrackerServiceImplBase implements io.grpc.BindableService {

    /** */
    public void register(
        io.github.gravetii.generated.DiztilPojo.Node request,
        io.grpc.stub.StreamObserver<io.github.gravetii.generated.DiztilPojo.Node>
            responseObserver) {
      asyncUnimplementedUnaryCall(getRegisterMethod(), responseObserver);
    }

    /** */
    public void search(
        io.github.gravetii.generated.DiztilPojo.SearchRequest request,
        io.grpc.stub.StreamObserver<io.github.gravetii.generated.DiztilPojo.SearchResponse>
            responseObserver) {
      asyncUnimplementedUnaryCall(getSearchMethod(), responseObserver);
    }

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
              getRegisterMethod(),
              asyncUnaryCall(
                  new MethodHandlers<
                      io.github.gravetii.generated.DiztilPojo.Node,
                      io.github.gravetii.generated.DiztilPojo.Node>(this, METHODID_REGISTER)))
          .addMethod(
              getSearchMethod(),
              asyncServerStreamingCall(
                  new MethodHandlers<
                      io.github.gravetii.generated.DiztilPojo.SearchRequest,
                      io.github.gravetii.generated.DiztilPojo.SearchResponse>(
                      this, METHODID_SEARCH)))
          .build();
    }
  }

  /** */
  public static final class TrackerServiceStub
      extends io.grpc.stub.AbstractStub<TrackerServiceStub> {
    private TrackerServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private TrackerServiceStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TrackerServiceStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new TrackerServiceStub(channel, callOptions);
    }

    /** */
    public void register(
        io.github.gravetii.generated.DiztilPojo.Node request,
        io.grpc.stub.StreamObserver<io.github.gravetii.generated.DiztilPojo.Node>
            responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getRegisterMethod(), getCallOptions()), request, responseObserver);
    }

    /** */
    public void search(
        io.github.gravetii.generated.DiztilPojo.SearchRequest request,
        io.grpc.stub.StreamObserver<io.github.gravetii.generated.DiztilPojo.SearchResponse>
            responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(getSearchMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /** */
  public static final class TrackerServiceBlockingStub
      extends io.grpc.stub.AbstractStub<TrackerServiceBlockingStub> {
    private TrackerServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private TrackerServiceBlockingStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TrackerServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new TrackerServiceBlockingStub(channel, callOptions);
    }

    /** */
    public io.github.gravetii.generated.DiztilPojo.Node register(
        io.github.gravetii.generated.DiztilPojo.Node request) {
      return blockingUnaryCall(getChannel(), getRegisterMethod(), getCallOptions(), request);
    }

    /** */
    public java.util.Iterator<io.github.gravetii.generated.DiztilPojo.SearchResponse> search(
        io.github.gravetii.generated.DiztilPojo.SearchRequest request) {
      return blockingServerStreamingCall(
          getChannel(), getSearchMethod(), getCallOptions(), request);
    }
  }

  /** */
  public static final class TrackerServiceFutureStub
      extends io.grpc.stub.AbstractStub<TrackerServiceFutureStub> {
    private TrackerServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private TrackerServiceFutureStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TrackerServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new TrackerServiceFutureStub(channel, callOptions);
    }

    /** */
    public com.google.common.util.concurrent.ListenableFuture<
            io.github.gravetii.generated.DiztilPojo.Node>
        register(io.github.gravetii.generated.DiztilPojo.Node request) {
      return futureUnaryCall(getChannel().newCall(getRegisterMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_REGISTER = 0;
  private static final int METHODID_SEARCH = 1;

  private static final class MethodHandlers<Req, Resp>
      implements io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final TrackerServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(TrackerServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_REGISTER:
          serviceImpl.register(
              (io.github.gravetii.generated.DiztilPojo.Node) request,
              (io.grpc.stub.StreamObserver<io.github.gravetii.generated.DiztilPojo.Node>)
                  responseObserver);
          break;
        case METHODID_SEARCH:
          serviceImpl.search(
              (io.github.gravetii.generated.DiztilPojo.SearchRequest) request,
              (io.grpc.stub.StreamObserver<io.github.gravetii.generated.DiztilPojo.SearchResponse>)
                  responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private abstract static class TrackerServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    TrackerServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return io.github.gravetii.generated.Diztil.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("TrackerService");
    }
  }

  private static final class TrackerServiceFileDescriptorSupplier
      extends TrackerServiceBaseDescriptorSupplier {
    TrackerServiceFileDescriptorSupplier() {}
  }

  private static final class TrackerServiceMethodDescriptorSupplier
      extends TrackerServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    TrackerServiceMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (TrackerServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new TrackerServiceFileDescriptorSupplier())
                      .addMethod(getRegisterMethod())
                      .addMethod(getSearchMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
