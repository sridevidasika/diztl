package io.github.gravetii.node.indexer;

import io.github.gravetii.common.DiztilUtils;
import io.github.gravetii.generated.DiztilPojo;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.monitor.FileAlterationListenerAdaptor;
import org.apache.commons.io.monitor.FileAlterationMonitor;
import org.apache.commons.io.monitor.FileAlterationObserver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class BasicFileIndexer extends FileIndexer {
  private static final Logger logger =
      LoggerFactory.getLogger(BasicFileIndexer.class.getCanonicalName());

  private FileAlterationMonitor dirMonitor;

  public static BasicFileIndexer newDefaultIndexer() {
    return new BasicFileIndexer(DiztilUtils.DEFAULT_SHARE_PATH);
  }

  public BasicFileIndexer(String dir) {
    super(dir);
    this.monitor();
  }

  @Override
  public void index() {
    Collection<File> files = FileUtils.listFiles(sourceDir, null, true);
    int counter = 0;
    for (File file : files) {
      DiztilPojo.FileMetadata metadata =
          DiztilPojo.FileMetadata.newBuilder().setId(++counter).setName(file.getName()).build();
      this.indexedFiles.add(metadata);
    }

    logger.info("Finished indexing files in share directory {}", sourceDir);
  }

  @Override
  public List<DiztilPojo.FileMetadata> search(String pattern) {
    List<DiztilPojo.FileMetadata> result = new ArrayList<>();
    this.indexedFiles.forEach(
        indexedFile -> {
          if (indexedFile.getName().contains(pattern)) {
            result.add(indexedFile);
          }
        });

    return result;
  }

  private void reIndex() {
    logger.info("Re-indexing share directory {}", sourceDir);
    this.index();
    logger.info("Re-indexing done.");
  }

  private void monitor() {
    try {
      FileAlterationObserver observer = new FileAlterationObserver(sourceDir);
      observer.addListener(new FileChangeListener());
      dirMonitor = new FileAlterationMonitor(5000, observer);
      dirMonitor.start();
    } catch (Exception e) {
      logger.error("Error while starting directory monitor", e);
    }

    Runtime.getRuntime()
        .addShutdownHook(
            new Thread(
                () -> {
                  try {
                    this.dirMonitor.stop();
                    logger.info("Successfully stopped directory monitor");
                  } catch (Exception e) {
                    logger.error("Error while stopping directory monitor", e);
                  }
                }));
  }

  private class FileChangeListener extends FileAlterationListenerAdaptor {
    @Override
    public void onFileCreate(File file) {
      logger.info("New file created - {}", file);
      BasicFileIndexer.this.reIndex();
    }

    @Override
    public void onFileChange(File file) {
      logger.info("Existing file changed - {}", file);
      BasicFileIndexer.this.reIndex();
    }

    @Override
    public void onFileDelete(File file) {
      logger.info("Existing file deleted - {}", file);
      BasicFileIndexer.this.reIndex();
    }
  }

  public static void main(String[] args) throws Exception {
    String shareDir = DiztilUtils.DEFAULT_SHARE_PATH;
    System.out.println(shareDir);
    BasicFileIndexer indexer = new BasicFileIndexer(shareDir);
    System.out.println(indexer.getIndexedFiles());
  }
}
