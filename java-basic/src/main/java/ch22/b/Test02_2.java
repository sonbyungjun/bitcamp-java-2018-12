package ch22.b;

import java.io.FileInputStream;

public class Test02_2 {
  public static void main(String[] args) {

    try {

      FileInputStream in = new FileInputStream("data.bin");
      

      byte[] buf = new byte[1024];

      int count = in.read(buf);
      
      for (int i = 0; i < count; i++ ) {
        System.out.print(Integer.toHexString(buf[i]) + " ");
      }
      System.out.println();
      in.close();

    } catch (Exception e) {
      e.printStackTrace();
    }
    System.out.println("출력 완료.");
  }
}
