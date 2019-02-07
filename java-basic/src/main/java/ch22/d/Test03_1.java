package ch22.d;

import java.io.FileWriter;

public class Test03_1 {
  
  public static void main(String[] args) {
    
    try (FileWriter out = new FileWriter("data.txt")) {
      
      out.write("ABC가각간012#!?");
      
    } catch (Exception e) {
      e.printStackTrace();
    }
    
    System.out.println("출력 완료!");
  }
  
}
