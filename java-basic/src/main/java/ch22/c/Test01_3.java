package ch22.c;

import java.io.FileInputStream;

public class Test01_3 {
  public static void main(String[] args) {
    
    try {
      FileInputStream in = new FileInputStream("jls11.pdf");
      
      BufferedInputStream in2 = new BufferedInputStream(in);
      
      System.out.println("데이터 읽는 중...");
      
      long start = System.currentTimeMillis();
      
      int b;
      
      int count = 0;
      
      while ((b = in2.read()) != -1) {
        count++;
      }
      System.out.println();
      long end = System.currentTimeMillis();
      System.out.println(end - start);
      System.out.println(count);
      in.close();

    } catch (Exception e) {
      e.printStackTrace();
    }
    System.out.println("출력 완료.");
  }
}
