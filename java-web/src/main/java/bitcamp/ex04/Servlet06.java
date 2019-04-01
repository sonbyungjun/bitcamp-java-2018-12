package bitcamp.ex04;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet("/ex04/s6")
public class Servlet06 extends GenericServlet {
  
  private static final long serialVersionUID = 1L;

  @Override
  public void service(ServletRequest req, ServletResponse res)
      throws ServletException, IOException {
   
   req.setCharacterEncoding("UTF-8");
   String[] names = req.getParameterValues("name");
   
    res.setContentType("text/plain;charset=UTF-8");
    PrintWriter out = res.getWriter();

    for (String name : names) {
      out.printf("이름=%s\n", name);
    }
  }
  
}