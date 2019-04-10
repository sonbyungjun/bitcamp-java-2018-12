package com.eomcs.lms.servlet;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.context.ApplicationContext;
import com.eomcs.lms.controller.PageController;

@MultipartConfig(maxFileSize = 1024 * 1024 * 5)
@SuppressWarnings("serial")
@WebServlet("/app/*")
public class DispatcherServlet extends HttpServlet{

  @Override
  protected void service(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    String pageControllPath = request.getPathInfo();
    ApplicationContext iocContainer = (ApplicationContext) getServletContext().getAttribute("iocContainer");

    try {

      PageController pageController = (PageController) iocContainer.getBean(pageControllPath);

      String viewUrl = pageController.execute(request, response);

      if (viewUrl.startsWith("redirect:")) {
        response.sendRedirect(viewUrl.substring(9)); 
      } else {
        response.setContentType("text/html;charset=UTF-8");
        request.getRequestDispatcher(viewUrl).include(request, response);
      }

    } catch (Exception e) {
      request.setAttribute("error", e);
      request.setAttribute("error.title", "요청 처리 오류");
      request.setAttribute("error.content", e.getMessage());
      request.getRequestDispatcher("/error.jsp").forward(request, response);
    }

  }
}


