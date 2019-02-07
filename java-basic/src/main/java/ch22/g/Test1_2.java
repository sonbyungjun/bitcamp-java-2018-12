package ch22.g;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class Test1_2 {
  public static void main(String[] args) {
    
    try (ObjectInputStream in = new ObjectInputStream(
        new FileInputStream("score1.data"))) {
      
      Score1 score = (Score1) in.readObject();
      System.out.println(score);
      
    } catch (Exception e) {
      e.printStackTrace();
    }
    
  }
}
