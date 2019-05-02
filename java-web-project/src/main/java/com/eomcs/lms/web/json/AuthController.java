package com.eomcs.lms.web.json;
import java.util.HashMap;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.eomcs.lms.domain.Member;
import com.eomcs.lms.service.MemberService;

@RestController("json/AuthController")
@RequestMapping("/json/auth")
public class AuthController {

  @Autowired
  MemberService memberService;
  
  @Autowired
  ServletContext servletContext;
  
  final static Logger logger = LogManager.getLogger(AuthController.class);
  
  @PostMapping("login")
  public Object login(
      String email,
      String password,
      HttpSession session,
      HttpServletResponse response) throws Exception {
    
    Member member = memberService.get(email, password);
    
    HashMap<String,Object> content = new HashMap<>();
    
    if (member == null) {
      content.put("status", "fail");
      content.put("message", "이메일 없거나 암호가 맞지 않습니다.");
    } else {
      session.setAttribute("loginUser", member);
      content.put("status", "success");
    }
    return content;
  }
  
  @GetMapping("logout")
  public Object logout(HttpSession session) throws Exception {
    
    logger.debug("세션 무효화시킴!");
    logger.debug("loginUser: " + session.getAttribute("loginUser"));
    session.invalidate();
    
    HashMap<String,Object> content = new HashMap<>();
    content.put("status", "success");
    
    return content;
  }
  
  @GetMapping("user")
  public Object user(HttpSession session) throws Exception {
    
    Member loginUser = (Member) session.getAttribute("loginUser");
    
    HashMap<String,Object> content = new HashMap<>();
    
    if (loginUser != null) {
      content.put("status", "success");
      content.put("user", loginUser);
    } else {
      content.put("status", "fail");
    }
    
    return content;
  }
}


