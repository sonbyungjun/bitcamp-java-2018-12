package ch22.c;

import java.io.FileInputStream;

public class Test04_2 {
  public static void main(String[] args) {
    
    try (FileInputStream in = new FileInputStream("data.bin");
        DataInputStream in2 = new DataInputStream(in)) {
      
      int no = in2.readInt();
      String name = in2.readUTF();
      int age = in2.readInt();
      
      System.out.printf("%d, %s, %d\n", no, name, age);
      
      
    } catch (Exception e) {
      e.printStackTrace();
      
    }
    System.out.println("출력 완료.");
      
    }
  }

