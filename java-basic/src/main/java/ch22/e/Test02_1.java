package ch22.e;

import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.FileOutputStream;

public class Test02_1 {

  public static void main(String[] args) {

    Score[] students = {
        new Score("홍길동", 100, 100, 100),
        new Score("임꺽정", 90, 90, 90),
        new Score("유관순", 80, 80, 80)
    };

    try (DataOutputStream out = new DataOutputStream(
        new BufferedOutputStream(
            new FileOutputStream("score.data")))) {
      
      out.writeInt(students.length);
      
      for (Score s : students) {
        out.writeUTF(s.getName());
        out.writeInt(s.getKor());
        out.writeInt(s.getEng());
        out.writeInt(s.getMath());
      }
      
      out.flush();

    } catch (Exception e) {
      e.printStackTrace();
    }
    System.out.println("저장 완료");

  }

}
