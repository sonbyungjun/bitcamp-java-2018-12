package com.eomcs.lms.servlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.eomcs.lms.ServerApp;
import com.eomcs.lms.domain.Member;
import com.eomcs.lms.service.MemberService;

@SuppressWarnings("serial")
@WebServlet("/member/list")
public class MemberListServlet extends HttpServlet {
  
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    
    MemberService memberService = ServerApp.iocContainer.getBean(MemberService.class);
    
    List<Member> members = memberService.list(null);
    
    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();
    
    out.println("<html><head><title>회원 목록</title></head>");
    out.println("<body><h1>회원 목록</h1>");
    out.println("<p><a href='add'>회원가입</a></p>");
    out.println("<table border='2'>");
    out.println("<tr> <th>번호</th><th>이름</th><th>이메일</th><th>전화번호</th><th>생성일</th></tr>");
    
    for (Member member : members) {
      out.printf("<tr><td>%1$d</td> <td><a href='detail?no=%1$d'>%2$s</a></td> <td>%3$s</td> <td>%4$s</td> <td>%5$s</td></tr>", 
          member.getNo(), member.getName(), 
          member.getEmail(), member.getTel(), member.getRegisteredDate());
    }
    out.println("</table></body></html>");
    
    out.println("<form action='search'>");
    out.println("회원검색 : <input type='text' name='search'>");
    out.println("<button type='submit'>검색</button>");
    out.println("</form>");
    
  }
  
}