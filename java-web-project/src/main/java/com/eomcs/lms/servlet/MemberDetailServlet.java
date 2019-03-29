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
@WebServlet("/member/detail")
public class MemberDetailServlet extends HttpServlet {
  
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    
    MemberService memberService = ServerApp.iocContainer.getBean(MemberService.class);
    
    int no = Integer.parseInt(request.getParameter("no"));

    Member member = memberService.get(no);
    
    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();
    
    out.println("<html><head><title>회원 상세조회</title></head>");
    out.println("<body><h1>회원 상세조회</h1>");
    
    if (member == null) {
      out.println("<p>해당 회원이 없습니다.</p>");
      return;
    }
    
    out.println("<form action='update' method='post'>");
    out.println("<table border='1'>");
    out.printf("<tr>"
        + "<th>번호</th>"
        + "<td><input type='text' name='no' value='%d' readonly></td>"
        + "</tr>\n", no);
    out.printf("<tr><th>이름</th> "
        + "<td><input type='text' name='name' value='%s'></td>"
        + "</tr>", member.getName());
    out.println("<tr><th>암호</th> "
        + "<td><input type='password' name='password'></td>"
        + "</tr>");
    out.printf("<tr><th>이메일</th> "
        + "<td><input type='text' name='email' value='%s'></td>"
        + "</tr>", member.getEmail());
    out.printf("<tr><th>전화</th> "
        + "<td><input type='text' name='tel' value='%s'></td>"
        + "</tr>", member.getTel());
    out.printf("<tr><th>사진</th> "
        + "<td><input type='text' name='photo' value='%s'></td>"
        + "</tr>", member.getPhoto());
    out.printf("<tr><th>가입일</th> <td>%s</td> </tr>", member.getRegisteredDate());
    out.println("</table>");
    out.println("<p><a href='list'>목록</a>"
        + "<a href='delete?no=" + member.getNo() + "'>삭제</a>"
        + "<button type='submit'>변경</button>"
        + "</p>");
    out.println("</from>");
    out.println("</body></html>");
  }
}
