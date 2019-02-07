package ch22.e;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.FileInputStream;

public class Test02_2 {

  public static void main(String[] args) {

    Score[] students = null;

    try (DataInputStream in = new DataInputStream(
        new BufferedInputStream(
            new FileInputStream("score.data")))) {

      int len = in.readInt();
      students = new Score[len];

      for (int i = 0; i < students.length; i++) {
        Score s = new Score(in.readUTF(), in.readInt(), in.readInt(), in.readInt());
        students[i] = s;
      }

      for (Score s : students) {
        System.out.printf("%s, %d, %d, %d, %d, %.1f\n",
            s.getName(),
            s.getKor(),
            s.getEng(),
            s.getMath(),
            s.getSum(),
            s.getAver());
      }

    } catch (Exception e) {
      e.printStackTrace();
    }

  }
}

