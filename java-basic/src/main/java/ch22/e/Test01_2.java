package ch22.e;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.FileInputStream;

public class Test01_2 {

  public static void main(String[] args) {
    
    try (DataInputStream in = new DataInputStream(
        new BufferedInputStream(
            new FileInputStream("score.data")))) {
      
      Score s1 = new Score(in.readUTF(), in.readInt(), in.readInt(), in.readInt());
      
      Score s2 = new Score(in.readUTF(), in.readInt(), in.readInt(), in.readInt());
      
      Score s3 = new Score(in.readUTF(), in.readInt(), in.readInt(), in.readInt());
      
      print(s1);
      print(s2);
      print(s3);
      
    } catch (Exception e) {
      e.printStackTrace();
    }
    
    
    
  }
  
  static private void print(Score s) {
    System.out.printf("%s, %d, %d, %d, %d, %.1f\n",
        s.getName(),
        s.getKor(),
        s.getEng(),
        s.getMath(),
        s.getSum(),
        s.getAver());
  }
  
}
