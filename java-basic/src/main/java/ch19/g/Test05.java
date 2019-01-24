package ch19.g;

import java.io.File;
import java.io.FilenameFilter;

public class Test05 {
  
  public static void main(String[] args) {
    
    File dir = new File("./");

    FilenameFilter filter = new FilenameFilter() {
      @Override
      public boolean accept(File dir, String name) {
        if (name.endsWith(".txt"))
          return true;
        return false;
      }
    };
    
    String[] names = dir.list(filter);
    
    for (String name : names) {
      System.out.println(name);
    }
  }
}
