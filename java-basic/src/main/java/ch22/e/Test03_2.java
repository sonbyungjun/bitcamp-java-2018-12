package ch22.e;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.util.ArrayList;

public class Test03_2 {

  public static void main(String[] args) {

    ArrayList<Score> students = new ArrayList<>();

    try (DataInputStream in = new DataInputStream(
        new BufferedInputStream(
            new FileInputStream("score.data")))) {

      int len = in.readInt();

      for (int i = 0; i < len; i++) {
        Score s = new Score(in.readUTF(), in.readInt(), in.readInt(), in.readInt());
        students.add(s);
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

