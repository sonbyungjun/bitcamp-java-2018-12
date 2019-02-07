package ch22.c;

import java.io.FileInputStream;

public class Test04_3 {
  public static void main(String[] args) {
    
    try (FileInputStream in = new FileInputStream("data.bin");
        BufferedInputStream in1 = new BufferedInputStream(in);
        DataInputStream in2 = new DataInputStream(in1)) {
      
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

