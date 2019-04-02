package bitcamp.ex08;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(value="/ex08/s3")
@SuppressWarnings("serial")
public class Servlet03 extends HttpServlet {

  @Override
  protected void service(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    
    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();
    
    out.println("<html><head>");
    out.println("<title>리다이렉트</title>");
    out.println("</head><body>");
    for (int i = 0; i < 300; i++) {
      out.println("안녕하세요! - /ex08/s3");
    }
    out.println("</body></html>");
    
    response.sendRedirect("s100");
  }
  
}