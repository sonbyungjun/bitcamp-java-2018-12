package ch22.a;

import java.io.File;

public class Test05 {

  public static void main(String[] args) throws Exception{

    File file = new File("temp2/test.txt");
    if (file.createNewFile()) {
      System.out.println("파일이 생성됨");
    } else {
      System.out.println("파일을 생선하지 못함.");
    }

    file = new File("temp3/test.txt");
    if (file.createNewFile()) {
      System.out.println("파일이 생성됨");
    } else {
      System.out.println("파일을 생선하지 못함.");
    }
    
  }
}

