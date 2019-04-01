package bitcamp.ex07;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(value="/ex07/s11_error")
@SuppressWarnings("serial")
public class Servlet11_error extends HttpServlet {
  
  @Override
  protected void service(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    
    PrintWriter out = response.getWriter();
    out.println("해당 연산자를 지원하지 않습니다.");
    
  }
  
}