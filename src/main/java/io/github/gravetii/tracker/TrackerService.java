package io.github.gravetii.tracker;

import io.github.gravetii.generated.TrackerServiceGrpc;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

class TrackerService extends TrackerServiceGrpc.TrackerServiceImplBase {
  private static final Logger logger = LoggerFactory.getLogger(TrackerService.class.getCanonicalName());

  private NodeKeeper nodeKeeper;

  TrackerService() {
    this.nodeKeeper = new NodeKeeper();
  }



}
