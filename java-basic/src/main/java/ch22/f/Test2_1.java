package ch22.f;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class Test2_1 {
  public static void main(String[] args) {
    
    try (ObjectOutputStream out = new ObjectOutputStream(
        new FileOutputStream("score2.data"))) {
      
      out.writeObject(new Score2("홍길동", 100, 100, 100));
     
      System.out.println("출력 완료!");
      
    } catch (Exception e) {
      e.printStackTrace();
    }
    
  }
}
