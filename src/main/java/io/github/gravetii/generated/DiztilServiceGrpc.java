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
public final class DiztilServiceGrpc {

  private DiztilServiceGrpc() {}

  public static final String SERVICE_NAME = "io.github.gravetii.generated.DiztilService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          io.github.gravetii.generated.DiztilPojo.SearchRequest,
          io.github.gravetii.generated.DiztilPojo.SearchResponse>
      getSearchMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "search",
      requestType = io.github.gravetii.generated.DiztilPojo.SearchRequest.class,
      responseType = io.github.gravetii.generated.DiztilPojo.SearchResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          io.github.gravetii.generated.DiztilPojo.SearchRequest,
          io.github.gravetii.generated.DiztilPojo.SearchResponse>
      getSearchMethod() {
    io.grpc.MethodDescriptor<
            io.github.gravetii.generated.DiztilPojo.SearchRequest,
            io.github.gravetii.generated.DiztilPojo.SearchResponse>
        getSearchMethod;
    if ((getSearchMethod = DiztilServiceGrpc.getSearchMethod) == null) {
      synchronized (DiztilServiceGrpc.class) {
        if ((getSearchMethod = DiztilServiceGrpc.getSearchMethod) == null) {
          DiztilServiceGrpc.getSearchMethod =
              getSearchMethod =
                  io.grpc.MethodDescriptor
                      .<io.github.gravetii.generated.DiztilPojo.SearchRequest,
                          io.github.gravetii.generated.DiztilPojo.SearchResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(
                              "io.github.gravetii.generated.DiztilService", "search"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              io.github.gravetii.generated.DiztilPojo.SearchRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              io.github.gravetii.generated.DiztilPojo.SearchResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(new DiztilServiceMethodDescriptorSupplier("search"))
                      .build();
        }
      }
    }
    return getSearchMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          io.github.gravetii.generated.DiztilPojo.DownloadRequest,
          io.github.gravetii.generated.DiztilPojo.File>
      getUploadMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "upload",
      requestType = io.github.gravetii.generated.DiztilPojo.DownloadRequest.class,
      responseType = io.github.gravetii.generated.DiztilPojo.File.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<
          io.github.gravetii.generated.DiztilPojo.DownloadRequest,
          io.github.gravetii.generated.DiztilPojo.File>
      getUploadMethod() {
    io.grpc.MethodDescriptor<
            io.github.gravetii.generated.DiztilPojo.DownloadRequest,
            io.github.gravetii.generated.DiztilPojo.File>
        getUploadMethod;
    if ((getUploadMethod = DiztilServiceGrpc.getUploadMethod) == null) {
      synchronized (DiztilServiceGrpc.class) {
        if ((getUploadMethod = DiztilServiceGrpc.getUploadMethod) == null) {
          DiztilServiceGrpc.getUploadMethod =
              getUploadMethod =
                  io.grpc.MethodDescriptor
                      .<io.github.gravetii.generated.DiztilPojo.DownloadRequest,
                          io.github.gravetii.generated.DiztilPojo.File>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
                      .setFullMethodName(
                          generateFullMethodName(
                              "io.github.gravetii.generated.DiztilService", "upload"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              io.github.gravetii.generated.DiztilPojo.DownloadRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              io.github.gravetii.generated.DiztilPojo.File.getDefaultInstance()))
                      .setSchemaDescriptor(new DiztilServiceMethodDescriptorSupplier("upload"))
                      .build();
        }
      }
    }
    return getUploadMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static DiztilServiceStub newStub(io.grpc.Channel channel) {
    return new DiztilServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static DiztilServiceBlockingStub newBlockingStub(io.grpc.Channel channel) {
    return new DiztilServiceBlockingStub(channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static DiztilServiceFutureStub newFutureStub(io.grpc.Channel channel) {
    return new DiztilServiceFutureStub(channel);
  }

  /** */
  public abstract static class DiztilServiceImplBase implements io.grpc.BindableService {

    /** */
    public void search(
        io.github.gravetii.generated.DiztilPojo.SearchRequest request,
        io.grpc.stub.StreamObserver<io.github.gravetii.generated.DiztilPojo.SearchResponse>
            responseObserver) {
      asyncUnimplementedUnaryCall(getSearchMethod(), responseObserver);
    }

    /** */
    public void upload(
        io.github.gravetii.generated.DiztilPojo.DownloadRequest request,
        io.grpc.stub.StreamObserver<io.github.gravetii.generated.DiztilPojo.File>
            responseObserver) {
      asyncUnimplementedUnaryCall(getUploadMethod(), responseObserver);
    }

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
              getSearchMethod(),
              asyncUnaryCall(
                  new MethodHandlers<
                      io.github.gravetii.generated.DiztilPojo.SearchRequest,
                      io.github.gravetii.generated.DiztilPojo.SearchResponse>(
                      this, METHODID_SEARCH)))
          .addMethod(
              getUploadMethod(),
              asyncServerStreamingCall(
                  new MethodHandlers<
                      io.github.gravetii.generated.DiztilPojo.DownloadRequest,
                      io.github.gravetii.generated.DiztilPojo.File>(this, METHODID_UPLOAD)))
          .build();
    }
  }

  /** */
  public static final class DiztilServiceStub extends io.grpc.stub.AbstractStub<DiztilServiceStub> {
    private DiztilServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private DiztilServiceStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DiztilServiceStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new DiztilServiceStub(channel, callOptions);
    }

    /** */
    public void search(
        io.github.gravetii.generated.DiztilPojo.SearchRequest request,
        io.grpc.stub.StreamObserver<io.github.gravetii.generated.DiztilPojo.SearchResponse>
            responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getSearchMethod(), getCallOptions()), request, responseObserver);
    }

    /** */
    public void upload(
        io.github.gravetii.generated.DiztilPojo.DownloadRequest request,
        io.grpc.stub.StreamObserver<io.github.gravetii.generated.DiztilPojo.File>
            responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(getUploadMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /** */
  public static final class DiztilServiceBlockingStub
      extends io.grpc.stub.AbstractStub<DiztilServiceBlockingStub> {
    private DiztilServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private DiztilServiceBlockingStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DiztilServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new DiztilServiceBlockingStub(channel, callOptions);
    }

    /** */
    public io.github.gravetii.generated.DiztilPojo.SearchResponse search(
        io.github.gravetii.generated.DiztilPojo.SearchRequest request) {
      return blockingUnaryCall(getChannel(), getSearchMethod(), getCallOptions(), request);
    }

    /** */
    public java.util.Iterator<io.github.gravetii.generated.DiztilPojo.File> upload(
        io.github.gravetii.generated.DiztilPojo.DownloadRequest request) {
      return blockingServerStreamingCall(
          getChannel(), getUploadMethod(), getCallOptions(), request);
    }
  }

  /** */
  public static final class DiztilServiceFutureStub
      extends io.grpc.stub.AbstractStub<DiztilServiceFutureStub> {
    private DiztilServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private DiztilServiceFutureStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DiztilServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new DiztilServiceFutureStub(channel, callOptions);
    }

    /** */
    public com.google.common.util.concurrent.ListenableFuture<
            io.github.gravetii.generated.DiztilPojo.SearchResponse>
        search(io.github.gravetii.generated.DiztilPojo.SearchRequest request) {
      return futureUnaryCall(getChannel().newCall(getSearchMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_SEARCH = 0;
  private static final int METHODID_UPLOAD = 1;

  private static final class MethodHandlers<Req, Resp>
      implements io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final DiztilServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(DiztilServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_SEARCH:
          serviceImpl.search(
              (io.github.gravetii.generated.DiztilPojo.SearchRequest) request,
              (io.grpc.stub.StreamObserver<io.github.gravetii.generated.DiztilPojo.SearchResponse>)
                  responseObserver);
          break;
        case METHODID_UPLOAD:
          serviceImpl.upload(
              (io.github.gravetii.generated.DiztilPojo.DownloadRequest) request,
              (io.grpc.stub.StreamObserver<io.github.gravetii.generated.DiztilPojo.File>)
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

  private abstract static class DiztilServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    DiztilServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return io.github.gravetii.generated.Diztil.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("DiztilService");
    }
  }

  private static final class DiztilServiceFileDescriptorSupplier
      extends DiztilServiceBaseDescriptorSupplier {
    DiztilServiceFileDescriptorSupplier() {}
  }

  private static final class DiztilServiceMethodDescriptorSupplier
      extends DiztilServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    DiztilServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (DiztilServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new DiztilServiceFileDescriptorSupplier())
                      .addMethod(getSearchMethod())
                      .addMethod(getUploadMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
