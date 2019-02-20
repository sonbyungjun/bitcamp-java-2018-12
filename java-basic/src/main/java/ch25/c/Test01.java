package ch25.c;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class Test01 {

  public static void main(String[] args) {
    
    try (Connection con = DriverManager.getConnection(
        "jdbc:mariadb://localhost/bitcampdb", "bitcamp", "1111")) {

      try (PreparedStatement stmt = con.prepareStatement(
          "update x_board set title = ?, contents = ? where board_id = ?");
          Scanner keyboard = new Scanner(System.in)) {
        
        System.out.print("번호? ");
        String no = keyboard.nextLine();
        
        System.out.print("제목? ");
        String title = keyboard.nextLine();

        System.out.print("내용? ");
        String contents = keyboard.nextLine();
        
        String result = "update x_board set title = '"
            + title + "', contents = '" + contents + "' where board_id = "
            + no;
        
        int count = stmt.executeUpdate(result);
        
        if (!(count == 1)) {
          System.out.println("해당 번호의 게시물이 존재하지 않습니다.");
          return;
        }
        System.out.println("변경하였습니다.");
        
      }


    } catch (Exception e) {
      e.printStackTrace();
    }
    
    
  }
  
}
