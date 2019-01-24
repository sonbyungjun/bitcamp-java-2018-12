package ch19.g;

import java.io.File;
import java.io.FilenameFilter;

public class MyFilenameFilter implements FilenameFilter {
  @Override
  public boolean accept(File dir, String name) {
    if (name.endsWith(".txt"))
      return true;
    return false;
  }
}
