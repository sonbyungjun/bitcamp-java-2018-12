package bitcamp.ex07;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(value="/ex07/s11_minus")
@SuppressWarnings("serial")
public class Servlet11_minus extends HttpServlet {
  
  @Override
  protected void service(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    
    PrintWriter out = response.getWriter();
    
    int a = Integer.parseInt(request.getParameter("a"));
    int b = Integer.parseInt(request.getParameter("b"));
    
    out.printf("%d - %d = %d\n", a, b , (a - b));
  }
  
}