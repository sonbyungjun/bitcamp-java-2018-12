package ch22.a;

import java.io.File;

public class Test04 {

  public static void main(String[] args) throws Exception{

    File dir = new File("temp");
    if (dir.delete()) {
      System.out.println("디렉토리 삭제됨.");
    } else {
      System.out.println("디렉토리 삭제 못함.");
    }

    dir = new File("temp2");
    if (dir.delete()) {
      System.out.println("디렉토리 삭제됨.");
    } else {
      System.out.println("디렉토리 삭제 못함.");
    }
  }
}

