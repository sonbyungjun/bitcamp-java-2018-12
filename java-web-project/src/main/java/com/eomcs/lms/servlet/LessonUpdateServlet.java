package com.eomcs.lms.servlet;

import java.io.IOException;
import java.io.PrintWriter;
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

    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();

    if (lessonService.update(lesson) > 0) {
      response.sendRedirect("list");
      return;
    }
    
    response.setHeader("Refresh", "2;url=list");
    
    out.println("<html><head>"
        + "<title>강의 정보 변경</title>"
        + "</head>");
    out.println("<body><h1>강의 정보 변경</h1>");
    out.println("<p>해당 강의가 없습니다.</p>");
    out.println("</body></html>");
  }
}
