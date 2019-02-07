package ch22.c;

import java.io.FileInputStream;

public class Test04_1 {
  public static void main(String[] args) {
    
    try (FileInputStream in = new FileInputStream("data.bin")) {
     
      int value = 0;
      
      value = value | (in.read() << 24);
      value = value | (in.read() << 16);
      value = value | (in.read() << 8);
      value = value | in.read();
      
      System.out.println(Integer.toHexString(value));
      
    } catch (Exception e) {
      e.printStackTrace();
      
    }
    System.out.println("출력 완료.");
      
    }
  }

