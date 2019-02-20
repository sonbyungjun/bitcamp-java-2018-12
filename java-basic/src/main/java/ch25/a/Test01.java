package ch25.a;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Test01 {
  
  public static void main(String[] args) {
    
    try {
      DriverManager.registerDriver(new org.mariadb.jdbc.Driver());
    } catch (SQLException e) {
      System.out.println("MariaDB의 java.sql.Driver 구현체를 등록하는 중에 오류 발생! ");
      e.printStackTrace();
    }
    
    try (Connection con = DriverManager.getConnection(
        "jdbc:mariadb://localhost/bitcampdb", "bitcamp", "1111")) {
      System.out.println("DBMS에 연결 성공!");
      
    } catch (Exception e) {
      System.out.println("DBMS에 연결 중 오류 발생!");
      e.printStackTrace();
    }
    
    
  }
  
}
