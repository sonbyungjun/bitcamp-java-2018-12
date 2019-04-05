package com.eomcs.lms.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.context.ApplicationContext;
import com.eomcs.lms.domain.Lesson;
import com.eomcs.lms.service.LessonService;

@SuppressWarnings("serial")
@WebServlet("/lesson/detail")
public class LessonDetailServlet extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    
    LessonService lessonService = 
        ((ApplicationContext) getServletContext().getAttribute("iocContainer")).getBean(LessonService.class);
    int no = Integer.parseInt(request.getParameter("no"));

    Lesson lesson = lessonService.get(no);
    response.setContentType("text/html;charset=UTF-8");
    request.setAttribute("lesson", lesson);
    request.getRequestDispatcher("/lesson/detail.jsp").include(request, response);
    
  }
}
