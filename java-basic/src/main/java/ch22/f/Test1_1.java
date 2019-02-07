package ch22.f;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class Test1_1 {
  public static void main(String[] args) {
    
    try (ObjectOutputStream out = new ObjectOutputStream(
        new FileOutputStream("score1.data"))) {
      
      out.writeObject(new Score1("홍길동", 100, 100, 100));
      
      
    } catch (Exception e) {
      e.printStackTrace();
    }
    
  }
}
