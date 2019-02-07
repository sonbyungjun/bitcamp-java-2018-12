package ch22.e;

import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.FileOutputStream;

public class Test01_1 {

  public static void main(String[] args) {
    
    Score s1 = new Score("홍길동", 100, 100, 100);
    Score s2 = new Score("임꺽정", 90, 90, 90);
    Score s3 = new Score("유관순", 80, 80, 80);
    
    try (DataOutputStream out = new DataOutputStream(
        new BufferedOutputStream(
            new FileOutputStream("score.data")))) {
      
      out.writeUTF(s1.getName());
      out.writeInt(s1.getKor());
      out.writeInt(s1.getEng());
      out.writeInt(s1.getMath());
      
      out.writeUTF(s2.getName());
      out.writeInt(s2.getKor());
      out.writeInt(s2.getEng());
      out.writeInt(s2.getMath());
      
      out.writeUTF(s3.getName());
      out.writeInt(s3.getKor());
      out.writeInt(s3.getEng());
      out.writeInt(s3.getMath());
      
      out.flush();
      
      
    } catch (Exception e) {
      e.printStackTrace();
    }
    System.out.println("저장 완료");
    
  }
  
}
