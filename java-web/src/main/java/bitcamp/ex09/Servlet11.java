package bitcamp.ex09;

import java.io.IOException;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(value="/ex09/s11")
@SuppressWarnings("serial")
public class Servlet11 extends HttpServlet {

  @Override
  protected void service(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    ServletContext sc = this.getServletContext();
    sc.setAttribute("v1", "xxx");
    
    HttpSession session = request.getSession();
    session.setAttribute("v2", "yyy");
    
    request.setAttribute("v3", "zzz");
    
    request.getRequestDispatcher("s12").forward(request, response);
    
  }
}