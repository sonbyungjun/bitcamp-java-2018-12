package ch22.a;

import java.io.File;

public class Test07 {

  public static void main(String[] args) throws Exception{

    File file = new File("temp2/a/b/c/test.txt");
    
    //File dir = new File(file.getParent());
    //System.out.println(file.getParent());
    
    File dir = file.getParentFile();
    
    if (dir.mkdirs()) {
      System.out.println("디렉토리를 생성함.");
    } else {
      System.out.println("디렉토리를 생성 하지 못함.");
    }
    
    if (file.createNewFile()) {
      System.out.println("파일이 생성함.");
    } else {
      System.out.println("파일을 생성하지 못함.");
    }

  }
}

