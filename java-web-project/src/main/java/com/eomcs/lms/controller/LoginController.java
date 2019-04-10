package com.eomcs.lms.controller;
import javax.servlet.ServletContext;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import com.eomcs.lms.domain.Member;
import com.eomcs.lms.service.MemberService;

@Controller("/auth/login")
public class LoginController implements PageController {

  @Autowired
  MemberService memberService;

  static final String REFERER_URL = "refererUrl";

  @Override
  public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
    
    if (request.getMethod().equals("GET")) {
      HttpSession session = request.getSession();
      // http://localhost:8080/java-web-project/auth/login
      if (!request.getHeader("Referer").equals(request.getRequestURL().toString().replace(request.getRequestURI(),"")
          + request.getContextPath() + "/app/auth/login")) {
        session.setAttribute(REFERER_URL, request.getHeader("Referer"));
      }
      return "/auth/form.jsp";
    }

    // Spring IoC 컨테이너에서 BoardService 객체를 꺼낸다.

    Member member = memberService.get(
        request.getParameter("email"),
        request.getParameter("password"));
    
    ServletContext sc = request.getServletContext();
    
    Cookie cookie;
    if (request.getParameter("saveEmail") != null) {
      cookie = new Cookie("email", request.getParameter("email"));
      cookie.setMaxAge(60 * 60 * 24 * 15);
    } else {
      cookie = new Cookie("email", request.getParameter("email"));
      cookie.setMaxAge(0);
    }

    response.addCookie(cookie);

    HttpSession session = request.getSession();

    if (member == null) {
      return "/auth/fail.jsp";
    }

    session.setAttribute("loginUser", member);

    String refereUrl = (String) session.getAttribute(REFERER_URL);
    if (refereUrl == null) {
      return "redirect:" + sc.getContextPath();
    } else {
      return "redirect:" + refereUrl;
    }

  }
}


