package com.eomcs.lms.controller;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import javax.servlet.ServletContext;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.Part;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.eomcs.lms.domain.Member;
import com.eomcs.lms.service.MemberService;

@MultipartConfig(maxFileSize = 1024 * 1024 * 5)
@Controller
public class MemberController {

  @Autowired
  MemberService memberService;
  
  @Autowired
  ServletContext servletContext;
  
  @RequestMapping("/member/form")
  public String form() throws Exception {
    return "/member/form.jsp";
  }

  @RequestMapping("/member/add")
  public String add(Member member,
      @RequestParam("photoFile") Part photoFile) throws Exception {
    
    if (photoFile.getSize() > 0) {
      String filename = UUID.randomUUID().toString();
      String uploadDir = servletContext.getRealPath("/upload/member");
      photoFile.write(uploadDir + "/" + filename);
      member.setPhoto(filename);
    }
    memberService.add(member);
    return "redirect:list";
  }
  
  @RequestMapping("/member/delete")
  public String delete(@RequestParam("no") int no) throws Exception {
    if (memberService.delete(no) == 0) 
      throw new Exception("해당 번호의 회원이 없습니다.");
    return "redirect:list";
  }
  
  @RequestMapping("/member/detail")
  public String detail(@RequestParam("no") int no, Map<String,Object> map) throws Exception {
    Member member = memberService.get(no);
    map.put("member", member);
    return "/member/detail.jsp";
  }
  
  @RequestMapping("/member/list")
  public String list(Map<String,Object> map) throws Exception {
    List<Member> members = memberService.list(null);
    map.put("list", members);
    return "/member/list.jsp";
  }
  
  @RequestMapping("/member/search")
  public String search(@RequestParam("search") String keyword, Map<String,Object> map) throws Exception {
    List<Member> members = memberService.list(keyword);
    map.put("list", members);
    return "/member/search.jsp";
  }
  
  @RequestMapping("/member/update")
  public String update(
      Member member,
      @RequestParam("photoFile") Part photoFile) throws Exception {
    
    if (photoFile.getSize() > 0) {
      String filename = UUID.randomUUID().toString();
      String uploadDir = servletContext.getRealPath("/upload/member");
      photoFile.write(uploadDir + "/" + filename);
      member.setPhoto(filename);
    }
    
    if (memberService.update(member) == 0) 
      throw new Exception("해당 번호의 회원이 없습니다.");
    
    return "redirect:list";
  }
  
}
