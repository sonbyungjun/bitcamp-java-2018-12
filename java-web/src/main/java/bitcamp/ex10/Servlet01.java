package bitcamp.ex10;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ex10/s1")
@SuppressWarnings("serial")
public class Servlet01 extends HttpServlet {

  @Override
  protected void service(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    Cookie c1 = new Cookie("name", "hong");
    
    Cookie c2 = new Cookie("age", "20");
    
    Cookie c3 = new Cookie("working", "true");
    
    Cookie c4 = new Cookie("name2", "홍길동");
    
    Cookie c5 = new Cookie("name3", URLEncoder.encode("홍길동", "UTF-8"));
    
    response.addCookie(c1);
    response.addCookie(c2);
    response.addCookie(c3);
    response.addCookie(c4);
    response.addCookie(c5);
    
    response.setContentType("text/plain;charset=UTF-8");
    PrintWriter out = response.getWriter();
    
    out.println("/ex10/s1 - 쿠키 보냈습니다.");
    
  }
  
}