package com.eomcs.lms.controller;

import java.sql.Date;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import com.eomcs.lms.domain.Lesson;
import com.eomcs.lms.service.LessonService;

@Controller("/lesson/add")
public class LessonAddController implements PageController {

  @Autowired
  LessonService lessonService;

  @Override
  public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

    if (request.getMethod().equals("GET")) {
      return "/lesson/form.jsp";
    }
    Lesson lesson = new Lesson();
    lesson.setTitle(request.getParameter("title"));
    lesson.setContents(request.getParameter("contents"));
    lesson.setStartDate(Date.valueOf(request.getParameter("startDate")));
    lesson.setEndDate(Date.valueOf(request.getParameter("endDate")));
    lesson.setTotalHours(Integer.parseInt(request.getParameter("totalHours")));
    lesson.setDayHours(Integer.parseInt(request.getParameter("dayHours")));

    if (request.getParameter("title").length() == 0) {
      request.setAttribute("error.title", "수업정보 입력 오류");
      request.setAttribute("error.content", "수업 제목을 입력해주세요.");
      request.getRequestDispatcher("/error.jsp").forward(request, response);
    }

    lessonService.add(lesson);
    return "redirect:list";
  }
}
