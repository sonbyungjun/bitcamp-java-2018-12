package ch22.e;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Test04_1 {

  public static void main(String[] args) {

    ArrayList<Score> students = new ArrayList<>();
    students.add(new Score("홍길동", 100, 100, 100));
    students.add(new Score("임꺽정", 90, 90, 90));
    students.add(new Score("유관순", 80, 80, 80));

    try (ObjectOutputStream out = new ObjectOutputStream(
        new BufferedOutputStream(
            new FileOutputStream("score.data")))) {
      
      out.writeInt(students.size());
      
      for (Score s : students) {
        out.writeObject(s);
      }
      
      out.flush();

    } catch (Exception e) {
      e.printStackTrace();
    }
    System.out.println("저장 완료");

  }

}
