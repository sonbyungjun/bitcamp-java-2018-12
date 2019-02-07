package ch22.d;

import java.io.FileWriter;

public class Test01_1 {
  
  public static void main(String[] args) {
    
    try (FileWriter out = new FileWriter("data.txt")) {
      
      out.write('A');
      out.write('B');
      out.write('C');
      out.write('가');
      out.write('각');
      out.write('간');
      
    } catch (Exception e) {
      e.printStackTrace();
    }
    
    System.out.println("출력 완료!");
  }
  
}
