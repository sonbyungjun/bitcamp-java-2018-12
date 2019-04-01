package bitcamp.ex07;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(value="/ex07/s11")
@SuppressWarnings("serial")
public class Servlet04 extends HttpServlet {
  
  @Override
  protected void service(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    
    response.setContentType("text/plain;charset=UTF-8");
    PrintWriter out = response.getWriter();
    
    out.println("계산 결과:");
    
    out.println("------------------------------------------------------------------------");
    String op = request.getParameter("op");
    
    RequestDispatcher 요청배달자 = null;
    
    if (op.equals("+")) {
      요청배달자 = request.getRequestDispatcher("/ex07/s11_plus");
    } else if (op.contentEquals("-")) {
      요청배달자 = request.getRequestDispatcher("/ex07/s11_minus");
    } else {
      요청배달자 = request.getRequestDispatcher("/ex07/s11_error");
    }
    
    요청배달자.include(request, response);
    
    out.println("------------------------------------------------------------------------");
    
  }
  
}