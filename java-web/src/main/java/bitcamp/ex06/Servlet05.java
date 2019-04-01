package bitcamp.ex06;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ex06/s5")
@SuppressWarnings("serial")
public class Servlet05 extends HttpServlet {

  @Override
  protected void service(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    
    ServletContext sc = this.getServletContext();
    
    resp.setContentType("text/plain;charset=UTF-8");
    PrintWriter out = resp.getWriter();
    out.printf("driver=%s\n", sc.getInitParameter("jdbc.driver"));
    out.printf("url=%s\n", sc.getInitParameter("jdbc.url"));
    out.printf("username=%s\n", sc.getInitParameter("jdbc.username"));
    out.printf("password=%s\n", sc.getInitParameter("jdbc.password"));
    
  }
}