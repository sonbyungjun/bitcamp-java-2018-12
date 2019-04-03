package bitcamp.ex11;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/ex11/s12")
@SuppressWarnings("serial")
public class Servlet12 extends HttpServlet {
  
  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    
    HttpSession session = request.getSession();
    
    session.setAttribute("name", request.getParameter("name"));
    
    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();
    
    out.println("<html><head><title>페이지2</title></head><body>");
    out.println("<form action='s13' method='post'>");
    out.println("나이 : <input type='text' name='age'><br>");
    out.println("<button>다음</button>");
    out.println("</form>");
    out.println("</body></html>");
    
  }
}