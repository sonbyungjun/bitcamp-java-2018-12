package com.eomcs.lms.controller;
import java.util.UUID;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import com.eomcs.lms.domain.Member;
import com.eomcs.lms.service.MemberService;

@MultipartConfig(maxFileSize = 1024 * 1024 * 5)
@Controller("/member/update")
public class MemberUpdateController implements PageController {

  @Autowired
  MemberService memberService;

  @Override
  public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

    int no = Integer.parseInt(request.getParameter("no"));

    Member member = memberService.get(no);
    member.setName(request.getParameter("name"));
    member.setEmail(request.getParameter("email"));
    member.setTel(request.getParameter("tel"));

    Part photo = request.getPart("photo");
    if (photo.getSize() > 0) {
      String filename = UUID.randomUUID().toString();
      String uploadDir = request.getServletContext().getRealPath("/upload/member");
      System.out.println(uploadDir);
      photo.write(uploadDir + "/" + filename);
      member.setPhoto(filename);
    }

    if (request.getParameter("password") != null)
      member.setPassword(request.getParameter("password"));

    if (memberService.update(member) == 0) 
      throw new Exception("해당 번호의 회원이 없습니다.");

    return "redirect:list";
  }
}
