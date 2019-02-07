package ch22.g;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class Test2_2 {
  public static void main(String[] args) {
    
    try (ObjectInputStream in = new ObjectInputStream(
        new FileInputStream("score2.data"))) {
      
      Score2 score = (Score2) in.readObject();
      System.out.println(score);
      
    } catch (Exception e) {
      e.printStackTrace();
    }
    
  }
}
