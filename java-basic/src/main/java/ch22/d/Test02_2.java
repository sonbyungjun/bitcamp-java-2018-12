package ch22.d;

import java.io.FileReader;

public class Test02_2 {

  public static void main(String[] args) {

    try (FileReader in = new FileReader("data.txt")) {

      char[] cbuf = new char[1024];
      int len = in.read(cbuf);
      System.out.println(len);
      for (int i = 0; i < len; i++) {
        System.out.print(cbuf[i] + ",");
      }
      System.out.println();

    } catch (Exception e) {
      e.printStackTrace();
    }

    System.out.println("출력 완료!");
  }

}
