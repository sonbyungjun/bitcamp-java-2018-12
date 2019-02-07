package ch22.b;

import java.io.FileInputStream;

public class Test01_2 {
  public static void main(String[] args) {

    try {

      FileInputStream in = new FileInputStream("data.bin");

      int b;

//      while (true) {
//        b = in.read();
//        if (b == -1) 
//          break;
//        System.out.print(Integer.toHexString(b) + " ");
//      }
      
      while ((b = in.read()) != -1) {
        System.out.print(Integer.toHexString(b) + " ");
      }
      System.out.println();
      in.close();

    } catch (Exception e) {
      e.printStackTrace();
    }
    System.out.println("출력 완료.");
  }
}
