// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: tracker.proto

package io.github.gravetii.generated;

public final class Tracker {
  private Tracker() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\rtracker.proto\022\034io.github.gravetii.gene" +
      "rated\032\021diztil_pojo.proto2\317\001\n\016TrackerServ" +
      "ice\022T\n\010register\022\".io.github.gravetii.gen" +
      "erated.Node\032\".io.github.gravetii.generat" +
      "ed.Node\"\000\022g\n\006search\022+.io.github.gravetii" +
      ".generated.SearchRequest\032,.io.github.gra" +
      "vetii.generated.SearchResponse\"\0000\001b\006prot" +
      "o3"
    };
    com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner assigner =
        new com.google.protobuf.Descriptors.FileDescriptor.    InternalDescriptorAssigner() {
          public com.google.protobuf.ExtensionRegistry assignDescriptors(
              com.google.protobuf.Descriptors.FileDescriptor root) {
            descriptor = root;
            return null;
          }
        };
    com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
          io.github.gravetii.generated.DiztilPojo.getDescriptor(),
        }, assigner);
    io.github.gravetii.generated.DiztilPojo.getDescriptor();
  }

  // @@protoc_insertion_point(outer_class_scope)
}