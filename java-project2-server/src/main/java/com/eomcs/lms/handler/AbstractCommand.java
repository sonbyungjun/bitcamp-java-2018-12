package com.eomcs.lms.handler;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import com.eomcs.lms.util.ConnectionFactory;

public abstract class AbstractCommand implements Command {
  @Override
  public void execute(BufferedReader in, PrintWriter out) {
    try (Connection con = ConnectionFactory.create()) {
      execute(new Response(in, out));
      ConnectionFactory.create().commit();
    } catch (Exception e) {
      try {
        ConnectionFactory.create().rollback();
      } catch (SQLException e1) {}
      out.printf("실행 오류! : %s\n", e.getMessage());
    }
  }

  public void execute(Response response) throws Exception {}
}
