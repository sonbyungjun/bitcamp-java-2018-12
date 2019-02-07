package ch22.c;

import java.io.FileInputStream;

public class Test01_1 {
  public static void main(String[] args) {

    try {
      FileInputStream in = new FileInputStream("jls11.pdf");
      System.out.println("데이터 읽는 중...");
      long start = System.currentTimeMillis();
      int b;
      int count = 0;
      while ((b = in.read()) != -1) {
//        if (++count % 1000 == 0) 
//          System.out.print(".");
//        if (count % 20000 == 0)
//          System.out.println();
      }
      System.out.println();
      long end = System.currentTimeMillis();
      System.out.println(end - start);
      in.close();

    } catch (Exception e) {
      e.printStackTrace();
    }
    System.out.println("출력 완료.");
  }
}
