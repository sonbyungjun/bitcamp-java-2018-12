package bitcamp.ex03;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet("/ex03/s2")
public class Servlet02 extends GenericServlet {
  
  private static final long serialVersionUID = 1L;

  @Override
  public void service(ServletRequest req, ServletResponse res)
      throws ServletException, IOException {
    
    res.setContentType("text/plain;charset=UTF-8");
    PrintWriter out = res.getWriter();
    
    out.println("Hello!");
    out.println("안녕하세요!");
    out.println("こんにちは");
    out.println("您好");
    out.println("مع السلامة؛ إلى اللقاء!");
    
  }
  
}