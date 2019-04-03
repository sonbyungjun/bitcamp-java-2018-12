package com.eomcs.lms.servlet;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.context.ApplicationContext;
import com.eomcs.lms.domain.Board;
import com.eomcs.lms.service.BoardService;
import com.eomcs.lms.service.MemberService;

@SuppressWarnings("serial")
@WebServlet("/auth/login")
public class LoginServlet extends HttpServlet{

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    
    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();
    
    out.println("<html>");
    out.println("<head><title>로그인</title></head>");
    out.println("<body>");
    out.println("<h1>로그인</h1>");
    out.println("<form action='login' method='post'>");
    out.println("<table border='1'>");
    out.println("<tr>");
    out.println("  <th>이메일<th>");
    out.println("  <td><input type='email' name='emil'></td>");
    out.println("</tr>");
    out.println("<tr>");
    out.println("  <th>암호<th>");
    out.println("  <td><input type='password' name='password'></td>");
    out.println("</tr>");
    out.println("</table>");
    out.println("<p>");
    out.println("  <button>로그인</button>");
    out.println("</p>");
    out.println("</form>");
    out.println("</body>");
    out.println("</html>");
  }
  
  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    
    MemberService memberService = 
        ((ApplicationContext) getServletContext().getAttribute("iocContainer")).getBean(MemberService.class);
    
    Board board = new Board();
    board.setContents(request.getParameter("contents")
        + ":" + request.getRemoteAddr());
    
    
    response.sendRedirect("list");
  }
  
}


