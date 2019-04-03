package bitcamp.ex11;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/ex11/s14")
@SuppressWarnings("serial")
public class Servlet14 extends HttpServlet {
  
  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    
    HttpSession session = request.getSession();
    
    String tel = request.getParameter("tel");
    
    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();
    
    out.println("<html><head><title>페이지4</title></head><body>");
    out.printf("이름 : %s<br>\n", session.getAttribute("name"));
    out.printf("나이 : %s<br>\n", session.getAttribute("age"));
    out.printf("전화 : %s<br>\n", tel);
    out.println("</body></html>");
    
  }
}