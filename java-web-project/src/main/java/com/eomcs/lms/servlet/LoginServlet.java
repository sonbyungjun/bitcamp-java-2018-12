package com.eomcs.lms.servlet;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.context.ApplicationContext;
import com.eomcs.lms.domain.Member;
import com.eomcs.lms.service.MemberService;

@SuppressWarnings("serial")
@WebServlet("/auth/login")
public class LoginServlet extends HttpServlet{

  static final String REFERER_URL = "refererUrl";
  
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    
    HttpSession session = request.getSession();
    // http://localhost:8080/java-web-project/auth/login
    if (!request.getHeader("Referer").equals(request.getRequestURL().toString().replace(request.getRequestURI(),"")
          + request.getContextPath() + "/app/auth/login")) {
      session.setAttribute(REFERER_URL, request.getHeader("Referer"));
    }
    request.setAttribute("viewUrl", "/auth/form.jsp");
  }
  
  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    
    // Spring IoC 컨테이너에서 BoardService 객체를 꺼낸다.
    ServletContext sc = this.getServletContext();
    ApplicationContext iocContainer = 
        (ApplicationContext) sc.getAttribute("iocContainer");
    MemberService memberService = iocContainer.getBean(MemberService.class);
    
    Member member = memberService.get(
        request.getParameter("email"),
        request.getParameter("password"));
    
    Cookie cookie;
    if (request.getParameter("saveEmail") != null) {
      cookie = new Cookie("email", request.getParameter("email"));
      cookie.setMaxAge(60 * 60 * 24 * 15);
    } else {
      cookie = new Cookie("email", request.getParameter("email"));
      cookie.setMaxAge(0);
    }
    
    ArrayList<Cookie> cookies = new ArrayList<>();
    cookies.add(cookie);
    request.setAttribute("cookies", cookies);
    
    HttpSession session = request.getSession();
    
    if (member == null) {
      request.setAttribute("viewUrl", "/auth/fail.jsp");
      return;
    }
    
    session.setAttribute("loginUser", member);
    
    String refereUrl = (String) session.getAttribute(REFERER_URL);
    if (refereUrl == null) {
      request.setAttribute("viewUrl", "redirect:" + getServletContext().getContextPath());
    } else {
      request.setAttribute("viewUrl", "redirect:" + refereUrl);
    }
    
  }
}


