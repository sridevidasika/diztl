// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: diztil.proto

package io.github.gravetii.generated;

public final class DiztilServiceOuterClass {
  private DiztilServiceOuterClass() {}

  public static void registerAllExtensions(com.google.protobuf.ExtensionRegistryLite registry) {}

  public static void registerAllExtensions(com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions((com.google.protobuf.ExtensionRegistryLite) registry);
  }

  public static com.google.protobuf.Descriptors.FileDescriptor getDescriptor() {
    return descriptor;
  }

  private static com.google.protobuf.Descriptors.FileDescriptor descriptor;

  static {
    java.lang.String[] descriptorData = {
      "\n\024diztil_service.proto\022\034io.github.gravet"
          + "ii.generated\032\021diztil_pojo.proto2\327\001\n\rDizt"
          + "ilService\022e\n\006search\022+.io.github.gravetii"
          + ".generated.SearchRequest\032,.io.github.gra"
          + "vetii.generated.SearchResponse\"\000\022_\n\006uplo"
          + "ad\022-.io.github.gravetii.generated.Downlo"
          + "adRequest\032\".io.github.gravetii.generated"
          + ".File\"\0000\001b\006proto3"
    };
    com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner assigner =
        new com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner() {
          public com.google.protobuf.ExtensionRegistry assignDescriptors(
              com.google.protobuf.Descriptors.FileDescriptor root) {
            descriptor = root;
            return null;
          }
        };
    com.google.protobuf.Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(
        descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
          io.github.gravetii.generated.DiztilPojo.getDescriptor(),
        },
        assigner);
    io.github.gravetii.generated.DiztilPojo.getDescriptor();
  }

  // @@protoc_insertion_point(outer_class_scope)
}
