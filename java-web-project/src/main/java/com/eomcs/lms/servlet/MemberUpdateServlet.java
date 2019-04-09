package com.eomcs.lms.servlet;
import java.io.IOException;
import java.util.UUID;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import org.springframework.context.ApplicationContext;
import com.eomcs.lms.domain.Member;
import com.eomcs.lms.service.MemberService;

@MultipartConfig(maxFileSize = 1024 * 1024 * 5)
@SuppressWarnings("serial")
@WebServlet("/member/update")
public class MemberUpdateServlet extends HttpServlet {

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    MemberService memberService = 
        ((ApplicationContext) getServletContext().getAttribute("iocContainer")).getBean(MemberService.class);

    int no = Integer.parseInt(request.getParameter("no"));

    Member member = memberService.get(no);
    member.setName(request.getParameter("name"));
    member.setEmail(request.getParameter("email"));
    member.setTel(request.getParameter("tel"));

    Part photo = request.getPart("photo");
    if (photo.getSize() > 0) {
      String filename = UUID.randomUUID().toString();
      String uploadDir = this.getServletContext().getRealPath("/upload/member");
      System.out.println(uploadDir);
      photo.write(uploadDir + "/" + filename);
      member.setPhoto(filename);
    }

    if (request.getParameter("password") != null)
      member.setPassword(request.getParameter("password"));

    if (memberService.update(member) > 0) {
      request.setAttribute("viewUrl", "redirect:list");
    } else {
      request.setAttribute("error.title", "회원 변경");
      request.setAttribute("error.content", "해당 번호의 회원이 없습니다.");
    }
  }
}
