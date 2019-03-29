package com.eomcs.lms.servlet;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.eomcs.lms.ServerApp;
import com.eomcs.lms.domain.Member;
import com.eomcs.lms.service.MemberService;

@SuppressWarnings("serial")
@WebServlet("/member/add")
public class MemberAddServlet extends HttpServlet {
  
  
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    
    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();
    
    out.println("<html>");
    out.println("<head><title>회원가입</title></head>");
    out.println("<body>");
    out.println("<h1>회원가입</h1>");
    out.println("<form action='add' method='post'>");
    out.println("<table border='1'>");
    out.println("<tr>");
    out.println("<th>이름<th>");
    out.println("<td><input type='text' name='name'></td>");
    out.println("</tr>");
    out.println("<tr>");
    out.println("<th>암호<th>");
    out.println("<td><input type='password' name='password'></td>");
    out.println("</tr>");
    out.println("<tr>");
    out.println("<th>이메일<th>");
    out.println("<td><input type='text' name='email'></td>");
    out.println("</tr>");
    out.println("<tr>");
    out.println("<tr>");
    out.println("<th>전화<th>");
    out.println("<td><input type='text' name='tel'></td>");
    out.println("</tr>");
    out.println("<th>사진<th>");
    out.println("<td><input type='text' name='photo'></td>");
    out.println("</tr>");
    out.println("</table>");
    out.println("<p>");
    out.println("<button type='submit'>등록</button>");
    out.println("<a href='list'>목록</a>");
    out.println("</p>");
    out.println("</form>");
    out.println("</body>");
    out.println("</html>");
  }
  
  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    
    MemberService memberService = ServerApp.iocContainer.getBean(MemberService.class);
    
    Member member = new Member();
    
    request.setCharacterEncoding("UTF-8");
    member.setName(request.getParameter("name"));
    member.setEmail(request.getParameter("email"));
    member.setPassword(request.getParameter("password"));
    member.setPhoto(request.getParameter("photo"));
    member.setTel(request.getParameter("tel"));

    memberService.add(member);
    
    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();
    
    out.println("<html><head>"
        + "<title>회원가입</title>"
        + "<meta http-equiv='Refresh' content='1;url=list'>"
        + "</head>");
    out.println("<body><h1>회원가입</h1>");
    out.println("<p>회원가입을 완료하였습니다.</p>");
    out.println("</body></html>");
  }
}
