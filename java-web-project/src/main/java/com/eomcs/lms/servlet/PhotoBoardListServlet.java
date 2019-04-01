package com.eomcs.lms.servlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.eomcs.lms.InitServlet;
import com.eomcs.lms.domain.PhotoBoard;
import com.eomcs.lms.service.PhotoBoardService;

@SuppressWarnings("serial")
@WebServlet("/photoboard/list")
public class PhotoBoardListServlet extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    
    PhotoBoardService photoBoardService = InitServlet.iocContainer.getBean(PhotoBoardService.class);
    
    List<PhotoBoard> boards = photoBoardService.list(0, null);

    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();
    
    out.println("<html><head><title>사진 게시판</title></head>");
    out.println("<body><h1>사진 게시판</h1>");
    out.println("<p><a href='add'>사진게시판등록</a></p>");
    out.println("<table border='1'>");
    out.println("<tr> <th>번호</th><th>제목</th><th>강의제목</th><th>조회수</th><th>생성일</th></tr>");

    for (PhotoBoard board : boards) {
      out.printf("<tr><td>%1$d</td> "
          + "<td><a href='detail?no=%1$d'>%2$s</a></td> "
          + "<td>%3$s</td> "
          + "<td>%4$s</td> "
          + "<td>%5$s</td></tr>", 
          board.getNo(), 
          board.getTitle(),
          board.getLessonNo(),
          board.getViewCount(),
          board.getCreatedDate());
    }
    out.println("</table>");
    
    out.println("<form action='search'>");
    out.println("수업번호: <input type='text' name='lessonNo'> ");
    out.println("검색어: <input type='text' name='keyword'> ");
    out.println("<button type='submit'>검색</button>");
    out.println("</form>");
    
    out.println("</body></html>");
  }
}
