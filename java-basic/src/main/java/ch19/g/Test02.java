package ch19.g;

import java.io.File;

public class Test02 {
  
  public static void main(String[] args) {
    File dir = new File("./");
    String[] names = dir.list(new MyFilenameFilter());
    
    for (String name : names) {
      System.out.println(name);
    }
  }
}
