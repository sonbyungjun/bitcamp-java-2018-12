package bitcamp.ex07;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(value="/ex07/s1")
@SuppressWarnings("serial")
public class Servlet01 extends HttpServlet {
  
  @Override
  protected void service(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    
    response.setContentType("text/plain;charset=UTF-8");
    PrintWriter out = response.getWriter();
    
    out.println("더하기 계산 결과:");
    
    String op = request.getParameter("op");
    if (!op.equals("+")) {
      RequestDispatcher 요청배달자 = request.getRequestDispatcher("/ex07/s2");
      요청배달자.forward(request, response);
      return;
    }
    
    int a = Integer.parseInt(request.getParameter("a"));
    int b = Integer.parseInt(request.getParameter("b"));
    
    out.printf("%d + %d = %d\n", a, b , (a + b));
  }
  
}