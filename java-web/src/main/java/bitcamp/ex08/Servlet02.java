package bitcamp.ex08;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(value="/ex08/s2")
@SuppressWarnings("serial")
public class Servlet02 extends HttpServlet {

  @Override
  protected void service(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    
    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();
    
    out.println("<html><head>");
    out.println("<meta http-equiv='Refresh' content='3;url=s100'>");
    out.println("</head><body>");
    out.println("안녕하세요! - /ex08/s2");
    out.println("</body></html>");
    
  }
  
}