package ch22.e;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class Test04_2 {

  public static void main(String[] args) {

    ArrayList<Score> students = new ArrayList<>();

    try (ObjectInputStream in = new ObjectInputStream(
        new BufferedInputStream(
            new FileInputStream("score.data")))) {

      int len = in.readInt();

      for (int i = 0; i < len; i++) {
        Score score = (Score) in.readObject();
        students.add(score);
      }

    } catch (Exception e) {
      e.printStackTrace();
    }
    
    for (Score s : students) {
      System.out.printf("%s, %d, %d, %d, %d, %.1f\n",
          s.getName(), s.getKor(), s.getEng(), s.getMath(),
          s.getSum(), s.getAver());
    }
    
  }
}

