package ch25.d;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Test01 {

  public static void main(String[] args) {
    
    try (Connection con = DriverManager.getConnection(
        "jdbc:mariadb://localhost/bitcampdb", "bitcamp", "1111")) {

      try (PreparedStatement stmt = con.prepareStatement(
          "insert into x_board(title,contents) values(?,?)", 
          Statement.RETURN_GENERATED_KEYS);
          Scanner keyboard = new Scanner(System.in)) {
        
        System.out.print("제목? ");
        String title = keyboard.nextLine();

        System.out.print("내용? ");
        String contents = keyboard.nextLine();
        
        stmt.setString(1, title);
        stmt.setString(2, contents);
        stmt.executeUpdate();
        
        int no = 0;
        try (ResultSet rs = stmt.getGeneratedKeys()) {
          rs.next();
          no = rs.getInt(1);
        }
        
        System.out.println("입력 성공!");
        System.out.println("입력된 게시물 번호: " + no);
        
      }


    } catch (Exception e) {
      e.printStackTrace();
    }
    
    
  }
  
}
