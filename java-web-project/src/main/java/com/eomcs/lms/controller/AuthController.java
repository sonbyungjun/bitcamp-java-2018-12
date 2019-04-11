package com.eomcs.lms.controller;
import javax.servlet.ServletContext;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.eomcs.lms.domain.Member;
import com.eomcs.lms.service.MemberService;

@Controller
public class AuthController {

  @Autowired
  MemberService memberService;
  
  @Autowired
  ServletContext servletContext;
  
  static final String REFERER_URL = "refererUrl";
  
  @RequestMapping("/auth/form")
  public String form(@RequestHeader("Referer") String refererUrl, HttpSession session) throws Exception {
    // http://localhost:8080/java-web-project/app/auth/login
    //if (!request.getHeader("Referer").equals(request.getRequestURL().toString().replace(request.getRequestURI(),"")
    //    + request.getContextPath() + "/app/auth/login")) {
    session.setAttribute(REFERER_URL, refererUrl);
    //}
    return "/auth/form.jsp";
  }

  @RequestMapping("/auth/login")
  public String login(
      @RequestParam("email") String email,
      @RequestParam("password") String password,
      @RequestParam("saveEmail") String saveEmail,
      HttpSession session,
      HttpServletResponse response) throws Exception {
    
    Member member = memberService.get(email, password);
    
    Cookie cookie;
    System.out.println("====> " + saveEmail);
    if (saveEmail != null) {
      cookie = new Cookie("email", email);
      cookie.setMaxAge(60 * 60 * 24 * 15);
    } else {
      cookie = new Cookie("email", "");
      cookie.setMaxAge(0);
    }

    response.addCookie(cookie);

    if (member == null) {
      return "/auth/fail.jsp";
    }

    session.setAttribute("loginUser", member);

    String refereUrl = (String) session.getAttribute(REFERER_URL);
    if (refereUrl == null) {
      return "redirect:" + servletContext.getContextPath();
    } else {
      return "redirect:" + refereUrl;
    }
  }
  
  @RequestMapping("/auth/logout")
  public String logout(HttpSession session) throws Exception {
    session.invalidate();
    return "redirect:../../";
  }
}


