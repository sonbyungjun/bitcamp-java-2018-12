package com.eomcs.lms.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.context.ApplicationContext;
import com.eomcs.lms.service.LessonService;

@SuppressWarnings("serial")
@WebServlet("/lesson/delete")
public class LessonDeleteServlet extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    LessonService lessonService = 
        ((ApplicationContext) getServletContext().getAttribute("iocContainer")).getBean(LessonService.class);

    int no = Integer.parseInt(request.getParameter("no"));

    if (lessonService.delete(no) > 0) {
      request.setAttribute("viewUrl", "redirect:list");
    } else {
      request.setAttribute("error.title", "수업 삭제");
      request.setAttribute("error.content", "해당 번호의 수업이 없습니다.");
    }
  }
}
