package ch22.b;

import java.io.FileOutputStream;

public class Test03_1 {
  public static void main(String[] args) {

    try {

      FileOutputStream out = new FileOutputStream("data.bin");

      byte[] bytes = {0x11, 0x22, 0x33, 0x44, 0x55, 0x66};
      
      out.write(bytes, 2, 3);
      
      out.close();

    } catch (Exception e) {
      e.printStackTrace();
    }
    System.out.println("출력 완료.");
  }
}
