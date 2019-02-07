package ch22.c;

import java.io.FileOutputStream;

public class Test02_2 {
  public static void main(String[] args) {

    FileOutputStream out = null;
    try {
      out = new FileOutputStream("data.bin");
      
      System.out.println("데이터 쓰는 중...");
      
      long start = System.currentTimeMillis();
      
      byte[] buf = new byte[1024];
      int size = 0;
      
      for (int i = 0; i < 1000000; i++) {
     
        buf[size++] = 0x55;
        
        if (size >= 1024) {
          out.write(buf);
          size = 0;
        }
        
      }
      
      out.write(buf, 0, size);
      
      long end = System.currentTimeMillis();
      
      System.out.println(end - start);
      

    } catch (Exception e) {
      e.printStackTrace();
      
    } finally {
      try {out.close();} catch (Exception e) {}
      
      }

    System.out.println("출력 완료.");
      
    }
  }

