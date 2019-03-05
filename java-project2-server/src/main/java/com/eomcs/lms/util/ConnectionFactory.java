package com.eomcs.lms.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {
  
  static ThreadLocal<Connection> conLocal = new ThreadLocal<>();
  
  public static Connection create() {
    try {
      Connection con = conLocal.get();
      if (con == null) {
        con = DriverManager.getConnection(
            "jdbc:mariadb://localhost/bitcampdb?user=bitcamp&password=1111");
       con.setAutoCommit(false);
        conLocal.set(con);
      }
      return con;
      
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
    
  }
}
