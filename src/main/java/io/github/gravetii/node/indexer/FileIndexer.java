package io.github.gravetii.node.indexer;

import io.github.gravetii.generated.DiztlPojo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.List;

public abstract class FileIndexer {
  private static final Logger logger =
      LoggerFactory.getLogger(FileIndexer.class.getCanonicalName());

  File sourceDir;
  List<DiztlPojo.FileMetadata> indexedFiles;

  FileIndexer(String dir) {
    this.sourceDir = check(dir);
    this.indexedFiles = new ArrayList<>();
    this.index();
  }

  private File check(String dir) {
    File sourceDir = new File(dir);
    if (!sourceDir.exists()) {
      boolean result = sourceDir.mkdirs();
      logger.debug("Share directory mkdirs - {}", result);
    }

    return sourceDir;
  }

  List<DiztlPojo.FileMetadata> getIndexedFiles() {
    return indexedFiles;
  }

  protected abstract void index();

  protected abstract List<DiztlPojo.FileMetadata> search(String pattern);
}
