package ch19.g;

import java.io.File;
import java.io.FilenameFilter;

public class Test04 {
  
  public static void main(String[] args) {
    
    class MyFilenameFilter implements FilenameFilter {
      @Override
      public boolean accept(File dir, String name) {
        if (name.endsWith(".txt"))
          return true;
        return false;
      }
    }
    File dir = new File("./");
    String[] names = dir.list(new MyFilenameFilter());
    
    for (String name : names) {
      System.out.println(name);
    }
  }
}
