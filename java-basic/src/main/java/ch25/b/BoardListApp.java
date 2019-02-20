package ch25.b;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class BoardListApp {
  
  // 다음과 같이 게시물 목록을 출력하라!
  // 게시물 번호를 내림차순으로 정렬하라.
  // ----------------------------
  // 번호, 제목, 등록일, 조회수
  // 2, aaa, 2019-1-1, 2
  // 1, bbb, 2018-12-31, 3
  //----------------------------
  public static void main(String[] args) {
    
    try (Connection con = DriverManager.getConnection(
        "jdbc:mariadb://localhost/bitcampdb", "bitcamp", "1111")) {
      
      try (Statement stmt = con.createStatement()) {
        ResultSet rs = stmt.executeQuery("select * from x_board order by board_id desc");
        
        System.out.println("-------------------------------------------");
        while (rs.next()) {
          System.out.printf("%s, %s, %s, %s\n",
              rs.getString("board_id"),
              rs.getString("title"),
              rs.getDate("created_date"),
              rs.getString("view_count"));
        }
        System.out.println("-------------------------------------------");
      }
      
      
    } catch (Exception e) {
      e.printStackTrace();
    }
    
  }
  
}
