package com.eomcs.lms.servlet;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@MultipartConfig(maxFileSize = 1024 * 1024 * 5)
@SuppressWarnings("serial")
@WebServlet("/app/*")
public class DispatcherServlet extends HttpServlet{

  @SuppressWarnings("unchecked")
  @Override
  protected void service(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    String pageControllPath = request.getPathInfo();

    request.getRequestDispatcher(pageControllPath).include(request, response);

    if (request.getAttribute("error.title") != null) {
      request.getRequestDispatcher("/error.jsp").forward(request, response);
      return;
    }
    
    List<Cookie> cookies = (List<Cookie>) request.getAttribute("cookies");
    if (cookies != null) {
      for (Cookie cookie : cookies) {
        response.addCookie(cookie);
      }
    }

    String viewUrl = (String) request.getAttribute("viewUrl");

    if (viewUrl.startsWith("redirect:")) {
      response.sendRedirect(viewUrl.substring(9)); 
    } else {
      response.setContentType("text/html;charset=UTF-8");
      request.getRequestDispatcher(viewUrl).include(request, response);
    }
  }
}


