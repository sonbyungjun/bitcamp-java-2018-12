package com.eomcs.lms.handler;

import java.io.PrintWriter;
import java.sql.Date;
import java.util.List;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import org.springframework.stereotype.Component;
import com.eomcs.lms.context.RequestMapping;
import com.eomcs.lms.domain.Lesson;
import com.eomcs.lms.service.LessonService;

@Component
public class LessonCommand {
  
  LessonService lessonService;
  
  public LessonCommand(LessonService lessonService) {
    this.lessonService = lessonService;
  }
  
  
  @RequestMapping("/lesson/list")
  public void list(ServletRequest request, ServletResponse response) throws Exception {
    List<Lesson> lessons = lessonService.list();
    
    PrintWriter out = response.getWriter();
    out.println("<html><head><title>강의 목록</title></head>");
    out.println("<body><h1>강의 목록</h1>");
    out.println("<p><a href='form'>강의등록</a></p>");
    out.println("<table border='1'>");
    out.println("<tr> <th>번호</th><th>제목</th><th>시작일</th><th>종료일</th><th>총 강의시간</th></tr>");
    
    for (Lesson lesson : lessons) {
      out.printf("<tr><td>%1$d</td> <td><a href='detail?no=%1$d'>%2$s</a></td> <td>%3$s</td> <td>%4$s</td> <td>%5$d</td></tr>", 
          lesson.getNo(), lesson.getTitle(), 
          lesson.getStartDate(), lesson.getEndDate(), lesson.getTotalHours());
    }
    out.println("</table></body></html>");
  }
  
  @RequestMapping("/lesson/add")
  public void add(ServletRequest request, ServletResponse response) throws Exception {
    Lesson lesson = new Lesson();
    lesson.setTitle(request.getParameter("title"));
    lesson.setContents(request.getParameter("contents"));
    lesson.setStartDate(Date.valueOf(request.getParameter("startDate")));
    lesson.setEndDate(Date.valueOf(request.getParameter("endDate")));
    lesson.setTotalHours(Integer.parseInt(request.getParameter("totalHours")));
    lesson.setDayHours(Integer.parseInt(request.getParameter("dayHours")));
    
    lessonService.add(lesson);
    
    PrintWriter out = response.getWriter();
    
    out.println("<html><head>"
        + "<title>강의등록</title>"
        + "<meta http-equiv='Refresh' content='1;url=list'>"
        + "</head>");
    out.println("<body><h1>강의등록</h1>");
    out.println("<p>강의등록을 완료하였습니다.</p>");
    out.println("</body></html>");
  }
  
  @RequestMapping("/lesson/detail")
  public void detail(ServletRequest request, ServletResponse response) throws Exception {
    int no = Integer.parseInt(request.getParameter("no"));

    Lesson lesson = lessonService.get(no);
    
    PrintWriter out = response.getWriter();
    out.println("<html><head><title>강의 상세조회</title></head>");
    out.println("<body><h1>강의 상세조회</h1>");
    
    if (lesson == null) {
      out.println("<p>해당 강의가 없습니다.</p>");
      return;
    }
    
    out.println("<form action='update'>");
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
  
  @RequestMapping("/lesson/update")
  public void update(ServletRequest request, ServletResponse response) throws Exception {
    int no = Integer.parseInt(request.getParameter("no"));
    
    Lesson lesson = lessonService.get(no);
    lesson.setTitle(request.getParameter("title"));
    lesson.setContents(request.getParameter("contents"));
    lesson.setStartDate(Date.valueOf(request.getParameter("startDate")));
    lesson.setEndDate(Date.valueOf(request.getParameter("endDate")));
    lesson.setTotalHours(Integer.parseInt(request.getParameter("totalHours")));
    lesson.setDayHours(Integer.parseInt(request.getParameter("dayHours")));
    
    PrintWriter out = response.getWriter();

    out.println("<html><head>"
        + "<title>강의 정보 변경</title>"
        + "<meta http-equiv='Refresh' content='1;url=list'>"
        + "</head>");
    out.println("<body><h1>강의 정보 변경</h1>");

    if (lessonService.update(lesson) == 0) {
      out.println("<p>해당 강의가 없습니다.</p>");
    } else {
      out.println("<p>변경했습니다.</p>");
    }
    out.println("</body></html>");
  }
  
  @RequestMapping("/lesson/delete")
  public void delete(ServletRequest request, ServletResponse response) throws Exception {
      int no = Integer.parseInt(request.getParameter("no"));
      
      PrintWriter out = response.getWriter();

      out.println("<html><head>"
          + "<title>강의 삭제</title>"
          + "<meta http-equiv='Refresh' content='1;url=list'>"
          + "</head>");
      out.println("<body><h1>강의 삭제</h1>");

      if (lessonService.delete(no) == 0) {
        out.println("<p>해당 강의가 없습니다.</p>");
      } else {
        out.println("<p>삭제했습니다.</p>");
      }
      out.println("</body></html>");

  }
  
  @RequestMapping("/lesson/form")
  public void form(ServletRequest request, ServletResponse response) throws Exception {
    PrintWriter out = response.getWriter();
    out.println("<html>");
    out.println("<head><title>강의등록</title></head>");
    out.println("<body>");
    out.println("<h1>강의등록</h1>");
    
    out.println("<form action='add'>");
    out.println("<table border='1'>");
    
    out.println("<tr>");
    out.println("<th>수업명<th>");
    out.println("<td><input type='text' name='title'></td>");
    out.println("</tr>");
    
    out.println("<tr>");
    out.println("<th>설명<th>");
    out.println("<td><textarea name='contents' rows='3' cols='50'></textarea></td>");
    out.println("</tr>");
    
    out.println("<tr>");
    out.println("<th>시작일<th>");
    out.println("<td><input type='date' name='startDate'></td>");
    out.println("</tr>");
    
    out.println("<tr>");
    out.println("<th>종료일<th>");
    out.println("<td><input type='date' name='endDate'></td>");
    out.println("</tr>");
    
    out.println("<tr>");
    out.println("<th>총수업시간<th>");
    out.println("<td><input type='number' name='totalHours'></td>");
    out.println("</tr>");
    
    out.println("<tr>");
    out.println("<th>일수업시간<th>");
    out.println("<td><input type='number' name='dayHours'></td>");
    out.println("</tr>");
    
    out.println("</table>");
    out.println("<p><button type='submit'>등록</button></p>");
    out.println("<p><a href='list'>목록</a></p>");
    out.println("</form>");
    out.println("</body>");
    out.println("</html>");
  }
  
}
