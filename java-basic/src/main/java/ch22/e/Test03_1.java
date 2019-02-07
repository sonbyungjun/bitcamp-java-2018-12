package ch22.e;

import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;

public class Test03_1 {

  public static void main(String[] args) {

    ArrayList<Score> students = new ArrayList<>();
    students.add(new Score("홍길동", 100, 100, 100));
    students.add(new Score("임꺽정", 90, 90, 90));
    students.add(new Score("유관순", 80, 80, 80));

    try (DataOutputStream out = new DataOutputStream(
        new BufferedOutputStream(
            new FileOutputStream("score.data")))) {
      
      out.writeInt(students.size());
      
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
