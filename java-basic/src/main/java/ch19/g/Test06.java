package ch19.g;

import java.io.File;
import java.io.FilenameFilter;

public class Test06 {
  
  public static void main(String[] args) {
    
    File dir = new File("./");
   
    String[] names = dir.list(new FilenameFilter() {
      @Override
      public boolean accept(File dir, String name) {
        if (name.endsWith(".txt"))
          return true;
        return false;
      }
    });
    
    for (String name : names) {
      System.out.println(name);
    }
  }
}
