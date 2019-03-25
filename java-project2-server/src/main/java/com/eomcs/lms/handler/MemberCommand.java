package com.eomcs.lms.handler;
import java.io.PrintWriter;
import java.util.List;
import org.springframework.stereotype.Component;
import com.eomcs.lms.context.RequestMapping;
import com.eomcs.lms.domain.Member;
import com.eomcs.lms.service.MemberService;

@Component
public class MemberCommand {
  
  MemberService memberService;
  
  public MemberCommand(MemberService memberService) {
    this.memberService = memberService;
  }
  
  @RequestMapping("/member/list")
  public void list(ServletRequest request, ServletResponse response) throws Exception {
    List<Member> members = memberService.list(null);
    
    PrintWriter out = response.getWriter();
    out.println("<html><head><title>회원 목록</title></head>");
    out.println("<body><h1>회원 목록</h1>");
    out.println("<p><a href='/member/form'>회원가입</a>");
    out.println("<a href='/lesson/list'>강의목록</a>");
    out.println("<a href='/board/list'>게시판</a></p>");
    out.println("<table border='2'>");
    out.println("<tr> <th>번호</th><th>이름</th><th>이메일</th><th>전화번호</th><th>생성일</th></tr>");
    
    for (Member member : members) {
      out.printf("<tr><td>%1$d</td> <td><a href='/member/detail?no=%1$d'>%2$s</a></td> <td>%3$s</td> <td>%4$s</td> <td>%5$s</td></tr>", 
          member.getNo(), member.getName(), 
          member.getEmail(), member.getTel(), member.getRegisteredDate());
    }
    out.println("</table></body></html>");
    
    out.println("<form action='/member/search'>");
    out.println("회원검색 : <input type='text' name='search'>");
    out.println("<button type='submit'>검색</button>");
    out.println("</form>");
    
  }
  
  @RequestMapping("/member/add")
  public void add(ServletRequest request, ServletResponse response) throws Exception {
    Member member = new Member();
    member.setName(request.getParameter("name"));
    member.setEmail(request.getParameter("email"));
    member.setPassword(request.getParameter("password"));
    member.setPhoto(request.getParameter("photo"));
    member.setTel(request.getParameter("tel"));

    memberService.add(member);
    
    PrintWriter out = response.getWriter();
    
    out.println("<html><head>"
        + "<title>회원가입</title>"
        + "<meta http-equiv='Refresh' content='1;url=/member/list'>"
        + "</head>");
    out.println("<body><h1>회원가입</h1>");
    out.println("<p>회원가입을 완료하였습니다.</p>");
    out.println("</body></html>");
  }
  
  @RequestMapping("/member/detail")
  public void detail(ServletRequest request, ServletResponse response) throws Exception {
    int no = Integer.parseInt(request.getParameter("no"));

    Member member = memberService.get(no);
    
    PrintWriter out = response.getWriter();
    out.println("<html><head><title>회원 상세조회</title></head>");
    out.println("<body><h1>회원 상세조회</h1>");
    
    if (member == null) {
      out.println("<p>해당 회원이 없습니다.</p>");
      return;
    }
    
    out.println("<form action='/member/update'>");
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
    out.println("<p><a href='/member/list'>목록</a>"
        + "<a href='/member/delete?no=" + member.getNo() + "'>삭제</a>"
        + "<button type='submit'>변경</button>"
        + "</p>");
    out.println("</from>");
    out.println("</body></html>");
  }
  
  @RequestMapping("/member/update")
  public void update(ServletRequest request, ServletResponse response) throws Exception {
    int no = Integer.parseInt(request.getParameter("no"));

    Member member = memberService.get(no);
    member.setName(request.getParameter("name"));
    member.setEmail(request.getParameter("email"));
    member.setPhoto(request.getParameter("photo"));
    member.setTel(request.getParameter("tel"));
    
    if (request.getParameter("password") != null)
      member.setPassword(request.getParameter("password"));
    
    PrintWriter out = response.getWriter();

    out.println("<html><head>"
        + "<title>회원 정보 변경</title>"
        + "<meta http-equiv='Refresh' content='1;url=/member/list'>"
        + "</head>");
    out.println("<body><h1>회원 정보 변경</h1>");

    if (memberService.update(member) == 0) {
      out.println("<p>해당 회원이 없습니다.</p>");
    } else {
      out.println("<p>변경했습니다.</p>");
    }
    out.println("</body></html>");
  }
  
  @RequestMapping("/member/delete")
  public void delete(ServletRequest request, ServletResponse response) throws Exception {
    int no = Integer.parseInt(request.getParameter("no"));

    PrintWriter out = response.getWriter();

    out.println("<html><head>"
        + "<title>회원 탈퇴</title>"
        + "<meta http-equiv='Refresh' content='1;url=/member/list'>"
        + "</head>");
    out.println("<body><h1>회원 탈퇴</h1>");

    if (memberService.delete(no) == 0) {
      out.println("<p>해당 회원이 없습니다.</p>");
    } else {
      out.println("<p>탈퇴했습니다.</p>");
    }
    out.println("</body></html>");

  }
  
  @RequestMapping("/member/search")
  public void search(ServletRequest request, ServletResponse response) throws Exception {
    
    String keyword = request.getParameter("search");
    List<Member> members = memberService.list(keyword);

    PrintWriter out = response.getWriter();
    out.println("<html><head><title>회원 목록</title></head>");
    out.println("<body><h1>회원 목록</h1>");
    out.println("<p><a href='/member/form'>회원가입</a>");
    out.println("<a href='/member/list'>회원목록</a>");
    out.println("<a href='/board/list'>게시판</a></p>");
    out.println("<table border='2'>");
    out.println("<tr> <th>번호</th><th>이름</th><th>이메일</th><th>전화번호</th><th>생성일</th></tr>");
    
    for (Member member : members) {
      out.println(String.format("<tr><td>%1$d</td> <td><a href='/member/detail?no=%1$d'>%2$s</a></td> <td>%3$s</td> <td>%4$s</td> <td>%5$s</td></tr>", 
          member.getNo(), member.getName(), 
          member.getEmail(), member.getTel(), member.getRegisteredDate()));
    }
    out.println("</table></body></html>");
  }
  
  @RequestMapping("/member/form")
  public void form(ServletRequest request, ServletResponse response) throws Exception {
    PrintWriter out = response.getWriter();
    out.println("<html>");
    out.println("<head><title>회원가입</title></head>");
    out.println("<body>");
    out.println("<h1>회원가입</h1>");
    out.println("<form action='/member/add'>");
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
    out.println("<a href='/member/list'>목록</a>");
    out.println("</p>");
    out.println("</form>");
    out.println("</body>");
    out.println("</html>");
  }
  
}
