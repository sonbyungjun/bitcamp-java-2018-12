package bitcamp.ex08;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(value="/ex08/s1")
@SuppressWarnings("serial")
public class Servlet01 extends HttpServlet {

  @Override
  protected void service(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    
    response.setContentType("text/plain;charset=UTF-8");
    PrintWriter out = response.getWriter();
    
    out.println("안녕하세요! - /ex08/s1");
    
    for (int i = 0; i < 100; i++) {
      out.println(i + "  ===> 1234567890123456789012345678901234567890");
    }
    
    response.setHeader("Refresh", "3;url=s100");
  }
  
}