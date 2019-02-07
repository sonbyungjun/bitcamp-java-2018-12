package ch22.b;

import java.io.FileOutputStream;

public class Test01_1 {
  public static void main(String[] args) {

    try {

      FileOutputStream out = new FileOutputStream("data.bin");

      out.write(2);
      out.write(40);
      out.write(100);
      out.write(101);
      out.write(102);
      out.write(127);
      out.write(0x11223344);
      out.write(0x55667788);
      
      out.close();

    } catch (Exception e) {
      e.printStackTrace();
    }
    System.out.println("출력 완료.");
  }
}
