package ch22.a;

import java.io.File;

public class Test13 {

  public static void main(String[] args) throws Exception{

    File dir = new File("bin");

    delete(dir);
    
    System.out.println("삭제 완료");
  }

  static void delete(File dir) {
    File[] files = dir.listFiles();
    for (File f : files) {
      if (f.isFile()) {
        f.delete();
      } else {
        delete(f);
      }
    }
    dir.delete();
  }

}

