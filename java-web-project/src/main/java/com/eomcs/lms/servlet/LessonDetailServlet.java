package com.eomcs.lms.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.eomcs.lms.InitServlet;
import com.eomcs.lms.domain.Lesson;
import com.eomcs.lms.service.LessonService;

@SuppressWarnings("serial")
@WebServlet("/lesson/detail")
public class LessonDetailServlet extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    
    LessonService lessonService = InitServlet.iocContainer.getBean(LessonService.class);
    int no = Integer.parseInt(request.getParameter("no"));

    Lesson lesson = lessonService.get(no);
    
    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();
    
    out.println("<html><head><title>강의 상세조회</title></head>");
    out.println("<body><h1>강의 상세조회</h1>");

    if (lesson == null) {
      out.println("<p>해당 강의가 없습니다.</p>");
      return;
    }

    out.println("<form action='update' method='post'>");
    out.println("<table border='1'>");
    out.printf("<tr>"
        + "<th>번호</th>"
        + "<td><input type='text' name='no' value='%d' readonly></td>"
        + "</tr>\n", no);
    out.printf("<tr><th>수업명</th> "
        + "<td><input type='text' name='title' value='%s'></td>"
        + "</tr>", lesson.getTitle());
    out.printf("<tr><th>설명</th> "
        + "<td><textarea name='contents' rows='3' cols='50'>%s</textarea></td>"
        + "</tr>", lesson.getContents());
    out.printf("<tr><th>기간</th> "
        + "<td><input type='date' name='startDate' value='%s'>~<input type='date' name='endDate' value='%s'></td>"
        + "</tr>", lesson.getStartDate(), lesson.getEndDate());
    out.printf("<tr><th>총수업시간</th> "
        + "<td><input type='number' name='totalHours' value='%s'></td>"
        + "</tr>", lesson.getTotalHours());
    out.printf("<tr><th>일수업시간</th> <td><input type='number' name='dayHours' value='%s'></td>"
        + "</tr>", lesson.getDayHours());
    out.println("</table>");
    out.println("<p><a href='list'>강의목록</a>"
        + "<a href='delete?no=" + lesson.getNo() + "'>삭제</a>"
        + "<button type='submit'>변경</button>"
        + "</p>");
    out.println("</from>");
    out.println("</body></html>");
  }

}
