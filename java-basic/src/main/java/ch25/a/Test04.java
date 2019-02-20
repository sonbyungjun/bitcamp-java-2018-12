package ch25.a;

import java.sql.DriverManager;

public class Test04 {
  
  public static void main(String[] args) {
    try {
      java.sql.Driver driver = DriverManager.getDriver("jdbc:mariadb:");
      System.out.println(driver);
      
    } catch (Exception e) {
      System.out.println("DBMS에 연결 중 오류 발생!");
      e.printStackTrace();
    }
  }
  
}
