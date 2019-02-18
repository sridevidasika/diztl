package io.github.gravetii.generated;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.18.0)",
    comments = "Source: diztl.proto")
public final class DiztlServiceGrpc {

  private DiztlServiceGrpc() {}

  public static final String SERVICE_NAME = "io.github.gravetii.generated.DiztlService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<io.github.gravetii.generated.DiztlPojo.SearchRequest,
      io.github.gravetii.generated.DiztlPojo.SearchResponse> getSearchMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "search",
      requestType = io.github.gravetii.generated.DiztlPojo.SearchRequest.class,
      responseType = io.github.gravetii.generated.DiztlPojo.SearchResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<io.github.gravetii.generated.DiztlPojo.SearchRequest,
      io.github.gravetii.generated.DiztlPojo.SearchResponse> getSearchMethod() {
    io.grpc.MethodDescriptor<io.github.gravetii.generated.DiztlPojo.SearchRequest, io.github.gravetii.generated.DiztlPojo.SearchResponse> getSearchMethod;
    if ((getSearchMethod = DiztlServiceGrpc.getSearchMethod) == null) {
      synchronized (DiztlServiceGrpc.class) {
        if ((getSearchMethod = DiztlServiceGrpc.getSearchMethod) == null) {
          DiztlServiceGrpc.getSearchMethod = getSearchMethod = 
              io.grpc.MethodDescriptor.<io.github.gravetii.generated.DiztlPojo.SearchRequest, io.github.gravetii.generated.DiztlPojo.SearchResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "io.github.gravetii.generated.DiztlService", "search"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  io.github.gravetii.generated.DiztlPojo.SearchRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  io.github.gravetii.generated.DiztlPojo.SearchResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new DiztlServiceMethodDescriptorSupplier("search"))
                  .build();
          }
        }
     }
     return getSearchMethod;
  }

  private static volatile io.grpc.MethodDescriptor<io.github.gravetii.generated.DiztlPojo.DownloadRequest,
      io.github.gravetii.generated.DiztlPojo.File> getUploadMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "upload",
      requestType = io.github.gravetii.generated.DiztlPojo.DownloadRequest.class,
      responseType = io.github.gravetii.generated.DiztlPojo.File.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<io.github.gravetii.generated.DiztlPojo.DownloadRequest,
      io.github.gravetii.generated.DiztlPojo.File> getUploadMethod() {
    io.grpc.MethodDescriptor<io.github.gravetii.generated.DiztlPojo.DownloadRequest, io.github.gravetii.generated.DiztlPojo.File> getUploadMethod;
    if ((getUploadMethod = DiztlServiceGrpc.getUploadMethod) == null) {
      synchronized (DiztlServiceGrpc.class) {
        if ((getUploadMethod = DiztlServiceGrpc.getUploadMethod) == null) {
          DiztlServiceGrpc.getUploadMethod = getUploadMethod = 
              io.grpc.MethodDescriptor.<io.github.gravetii.generated.DiztlPojo.DownloadRequest, io.github.gravetii.generated.DiztlPojo.File>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "io.github.gravetii.generated.DiztlService", "upload"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  io.github.gravetii.generated.DiztlPojo.DownloadRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  io.github.gravetii.generated.DiztlPojo.File.getDefaultInstance()))
                  .setSchemaDescriptor(new DiztlServiceMethodDescriptorSupplier("upload"))
                  .build();
          }
        }
     }
     return getUploadMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static DiztlServiceStub newStub(io.grpc.Channel channel) {
    return new DiztlServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static DiztlServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new DiztlServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static DiztlServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new DiztlServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class DiztlServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void search(io.github.gravetii.generated.DiztlPojo.SearchRequest request,
        io.grpc.stub.StreamObserver<io.github.gravetii.generated.DiztlPojo.SearchResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getSearchMethod(), responseObserver);
    }

    /**
     */
    public void upload(io.github.gravetii.generated.DiztlPojo.DownloadRequest request,
        io.grpc.stub.StreamObserver<io.github.gravetii.generated.DiztlPojo.File> responseObserver) {
      asyncUnimplementedUnaryCall(getUploadMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getSearchMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                io.github.gravetii.generated.DiztlPojo.SearchRequest,
                io.github.gravetii.generated.DiztlPojo.SearchResponse>(
                  this, METHODID_SEARCH)))
          .addMethod(
            getUploadMethod(),
            asyncServerStreamingCall(
              new MethodHandlers<
                io.github.gravetii.generated.DiztlPojo.DownloadRequest,
                io.github.gravetii.generated.DiztlPojo.File>(
                  this, METHODID_UPLOAD)))
          .build();
    }
  }

  /**
   */
  public static final class DiztlServiceStub extends io.grpc.stub.AbstractStub<DiztlServiceStub> {
    private DiztlServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private DiztlServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DiztlServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new DiztlServiceStub(channel, callOptions);
    }

    /**
     */
    public void search(io.github.gravetii.generated.DiztlPojo.SearchRequest request,
        io.grpc.stub.StreamObserver<io.github.gravetii.generated.DiztlPojo.SearchResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getSearchMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void upload(io.github.gravetii.generated.DiztlPojo.DownloadRequest request,
        io.grpc.stub.StreamObserver<io.github.gravetii.generated.DiztlPojo.File> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(getUploadMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class DiztlServiceBlockingStub extends io.grpc.stub.AbstractStub<DiztlServiceBlockingStub> {
    private DiztlServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private DiztlServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DiztlServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new DiztlServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public io.github.gravetii.generated.DiztlPojo.SearchResponse search(io.github.gravetii.generated.DiztlPojo.SearchRequest request) {
      return blockingUnaryCall(
          getChannel(), getSearchMethod(), getCallOptions(), request);
    }

    /**
     */
    public java.util.Iterator<io.github.gravetii.generated.DiztlPojo.File> upload(
        io.github.gravetii.generated.DiztlPojo.DownloadRequest request) {
      return blockingServerStreamingCall(
          getChannel(), getUploadMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class DiztlServiceFutureStub extends io.grpc.stub.AbstractStub<DiztlServiceFutureStub> {
    private DiztlServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private DiztlServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DiztlServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new DiztlServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<io.github.gravetii.generated.DiztlPojo.SearchResponse> search(
        io.github.gravetii.generated.DiztlPojo.SearchRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getSearchMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_SEARCH = 0;
  private static final int METHODID_UPLOAD = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final DiztlServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(DiztlServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_SEARCH:
          serviceImpl.search((io.github.gravetii.generated.DiztlPojo.SearchRequest) request,
              (io.grpc.stub.StreamObserver<io.github.gravetii.generated.DiztlPojo.SearchResponse>) responseObserver);
          break;
        case METHODID_UPLOAD:
          serviceImpl.upload((io.github.gravetii.generated.DiztlPojo.DownloadRequest) request,
              (io.grpc.stub.StreamObserver<io.github.gravetii.generated.DiztlPojo.File>) responseObserver);
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

  private static abstract class DiztlServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    DiztlServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return io.github.gravetii.generated.Diztl.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("DiztlService");
    }
  }

  private static final class DiztlServiceFileDescriptorSupplier
      extends DiztlServiceBaseDescriptorSupplier {
    DiztlServiceFileDescriptorSupplier() {}
  }

  private static final class DiztlServiceMethodDescriptorSupplier
      extends DiztlServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    DiztlServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (DiztlServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new DiztlServiceFileDescriptorSupplier())
              .addMethod(getSearchMethod())
              .addMethod(getUploadMethod())
              .build();
        }
      }
    }
    return result;
  }
}
