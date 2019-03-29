package com.eomcs.lms.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.eomcs.lms.ServerApp;
import com.eomcs.lms.domain.Lesson;
import com.eomcs.lms.service.LessonService;

@SuppressWarnings("serial")
@WebServlet("/lesson/list")
public class LessonListServlet extends HttpServlet {
  
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    
    LessonService lessonService = ServerApp.iocContainer.getBean(LessonService.class);
    
    List<Lesson> lessons = lessonService.list();
    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();
    out.println("<html><head><title>강의 목록</title></head>");
    out.println("<body><h1>강의 목록</h1>");
    out.println("<p><a href='add'>강의등록</a></p>");
    out.println("<table border='1'>");
    out.println("<tr> <th>번호</th><th>제목</th><th>시작일</th><th>종료일</th><th>총 강의시간</th></tr>");
    
    for (Lesson lesson : lessons) {
      out.printf("<tr><td>%1$d</td> <td><a href='detail?no=%1$d'>%2$s</a></td> <td>%3$s</td> <td>%4$s</td> <td>%5$d</td></tr>", 
          lesson.getNo(), lesson.getTitle(), 
          lesson.getStartDate(), lesson.getEndDate(), lesson.getTotalHours());
    }
    out.println("</table></body></html>");
  }
  
}
