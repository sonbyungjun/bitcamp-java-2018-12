package ch25.b;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

public class BoardDeleteApp {

  // 다음과 같이 게시물을 삭제하는 프로그램을 작성하라!
  // ----------------------------
  // 번호? 1
  // 삭제하였습니다.
  // (또는)
  // 해당 번호의 게시물이 존재하지 않습니다.
  //----------------------------
  public static void main(String[] args) {
    
    try (Connection con = DriverManager.getConnection(
        "jdbc:mariadb://localhost/bitcampdb", "bitcamp", "1111")) {

      try (Statement stmt = con.createStatement();
          Scanner keyboard = new Scanner(System.in)) {
        
        System.out.print("번호? ");
        String no = keyboard.nextLine();
        
        String result = "delete from x_board where board_id = " + no;
        
        int count = stmt.executeUpdate(result);
        
        if (!(count == 1)) {
          System.out.println("해당 번호의 게시물이 존재하지 않습니다.");
          return;
        }
        System.out.println("삭제하였습니다.");
        

      }


    } catch (Exception e) {
      e.printStackTrace();
    }
    
    
  }
  
}
