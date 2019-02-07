package ch22.g;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class Test3_1 {
  public static void main(String[] args) {
    
    try (ObjectOutputStream out = new ObjectOutputStream(
        new FileOutputStream("score3.data"))) {
      
      Score3 score = new Score3();
      score.setName("홍길동");
      score.setKor(100);
      score.setEng(100);
      score.setMath(100);
      
      out.writeObject(score);

      System.out.println("출력 완료!");
      
    } catch (Exception e) {
      e.printStackTrace();
    }
    
  }
}
