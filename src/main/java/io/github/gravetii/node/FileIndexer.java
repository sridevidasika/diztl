package io.github.gravetii.node;

import io.github.gravetii.common.DiztilConstants;
import io.github.gravetii.generated.DiztilPojo;
import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class FileIndexer {

  private static final Logger logger =
      LoggerFactory.getLogger(FileIndexer.class.getCanonicalName());

  private String shareDir;
  private List<DiztilPojo.FileMetadata> indexedFiles = new ArrayList<>();

  public static FileIndexer newDefaultIndexer() {
    return new FileIndexer(DiztilConstants.DEFAULT_SHARE_PATH);
  }

  FileIndexer(String shareDir) {
    this.shareDir = shareDir;
    this.index();
  }

  private void index() {
    File sourceDir = new File(shareDir);
    if (!sourceDir.exists()) {
      boolean result = sourceDir.mkdirs();
      logger.debug("Share directory mkdirs - {}", result);
    }

    Collection<File> allFiles = FileUtils.listFiles(sourceDir, null, true);
    List<File> files = new ArrayList<>(allFiles);

    for (int i = 0; i < files.size(); ++i) {
      File file = files.get(i);
      DiztilPojo.FileMetadata metadata =
          DiztilPojo.FileMetadata.newBuilder().setId(1 + i).setName(file.getName()).build();
      this.indexedFiles.add(metadata);
    }

    logger.info("Finished indexing files in share directory {}", shareDir);
  }

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

  private List<DiztilPojo.FileMetadata> getIndexedFiles() {
    return indexedFiles;
  }

  public static void main(String[] args) {
    String shareDir = DiztilConstants.DEFAULT_SHARE_PATH;
    System.out.println(shareDir);
    FileIndexer indexer = new FileIndexer(shareDir);
    System.out.println(indexer.getIndexedFiles());
  }
}
