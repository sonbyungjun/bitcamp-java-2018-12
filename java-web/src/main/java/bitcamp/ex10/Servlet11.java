package bitcamp.ex10;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ex10/s11")
@SuppressWarnings("serial")
public class Servlet11 extends HttpServlet {

  @Override
  protected void service(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    Cookie c1 = new Cookie("v1", "aaa");
    
    Cookie c2 = new Cookie("v2", "bbb");
    c2.setMaxAge(30);
    
    Cookie c3 = new Cookie("v3", "ccc");
    c3.setMaxAge(60);
    
    response.addCookie(c1);
    response.addCookie(c2);
    response.addCookie(c3);
    
    response.setContentType("text/plain;charset=UTF-8");
    PrintWriter out = response.getWriter();
    
    out.println("/ex10/s11 - 쿠키 보냈습니다.");
    
  }
  
}