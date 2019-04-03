package bitcamp.ex10;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ex10_1/s24")
@SuppressWarnings("serial")
public class Servlet24 extends HttpServlet {

  @Override
  protected void service(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    Cookie[] cookies = request.getCookies();

    response.setContentType("text/plain;charset=UTF-8");
    PrintWriter out = response.getWriter();

    if (cookies != null) {
      for (Cookie c : cookies) {
        out.printf("%s = %s\n", c.getName(), c.getValue());
      }
    }

  }

}