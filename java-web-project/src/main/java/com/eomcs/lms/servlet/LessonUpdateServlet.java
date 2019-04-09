package com.eomcs.lms.servlet;

import java.io.IOException;
import java.sql.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.context.ApplicationContext;
import com.eomcs.lms.domain.Lesson;
import com.eomcs.lms.service.LessonService;

@SuppressWarnings("serial")
@WebServlet("/lesson/update")
public class LessonUpdateServlet extends HttpServlet {

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    LessonService lessonService = 
        ((ApplicationContext) getServletContext().getAttribute("iocContainer")).getBean(LessonService.class);

    int no = Integer.parseInt(request.getParameter("no"));

    Lesson lesson = lessonService.get(no);
    lesson.setTitle(request.getParameter("title"));
    lesson.setContents(request.getParameter("contents"));
    lesson.setStartDate(Date.valueOf(request.getParameter("startDate")));
    lesson.setEndDate(Date.valueOf(request.getParameter("endDate")));
    lesson.setTotalHours(Integer.parseInt(request.getParameter("totalHours")));
    lesson.setDayHours(Integer.parseInt(request.getParameter("dayHours")));

    if (lessonService.update(lesson) > 0) {
      request.setAttribute("viewUrl", "redirect:list");
    } else {
      request.setAttribute("error.title", "수업 변경");
      request.setAttribute("error.content", "해당 번호의 수업이 없습니다.");
    }
  }
}
