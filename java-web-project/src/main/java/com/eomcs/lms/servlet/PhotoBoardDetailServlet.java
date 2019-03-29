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
import com.eomcs.lms.domain.PhotoBoard;
import com.eomcs.lms.domain.PhotoFile;
import com.eomcs.lms.service.PhotoBoardService;

@SuppressWarnings("serial")
@WebServlet("/photoboard/detail")
public class PhotoBoardDetailServlet extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    
    PhotoBoardService photoBoardService = ServerApp.iocContainer.getBean(PhotoBoardService.class);

    int no = Integer.parseInt(request.getParameter("no"));

    PhotoBoard board = photoBoardService.get(no);

    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();
    
    out.println("<html><head><title>사진게시판 상세조회</title></head>");
    out.println("<body><h1>사진게시판 상세조회</h1>");

    if (board == null) {
      out.println("<p>해당 사진게시판을 찾을 수 없습니다.</p>");
      return;
    }

    out.println("<form action='update' method='post'>");
    out.println("<table border='1'>");
    out.printf("<tr>"
        + "<th>번호</th>"
        + "<td><input type='text' name='no' value='%d' readonly></td>"
        + "</tr>\n", no);

    out.printf("<tr><th>제목</th> "
        + "<td><input type='text' name='title' value='%s'></td>"
        + "</tr>", board.getTitle());

    out.printf("<tr><th>작성일</th> "
        + "<td><input type='date' name='createdDate' value='%s'></td>"
        + "</tr>", board.getCreatedDate());

    out.printf("<tr><th>조회수</th> "
        + "<td><input type='text' name='viewCount' value='%d' readonly></td>"
        + "</tr>", board.getViewCount());

    out.printf("<tr><th>수업명</th> "
        + "<td><input type='text' name='totalHours' value='%s' readonly></td>"
        + "</tr>", board.getLesson().getTitle());
    
    out.printf("<tr><th>수업번호</th> "
        + "<td><input type='text' name='lessonNo' value='%s' readonly></td>"
        + "</tr>", board.getLesson().getNo());

    out.println(String.format("<tr><th>기간</th> "
        + "<td><input type='date' name='startDate' value='%s' readonly>~<input type='date' name='endDate' value='%s' readonly></td>"
        + "</tr>", board.getLesson().getStartDate(), board.getLesson().getEndDate()));

    out.println("<tr><th>사진파일</th> ");

    List<PhotoFile> files = board.getFiles();
    out.println("<td>");
    for (int i = 0; i < 5; i++) {
      if (i < files.size()) {
        out.printf("<input type='text' name='photo%d' value='%s'><br>", i+1, files.get(i).getFilePath());
      } else {
        out.printf("<input type='text' name='photo%s'><br>", i+1);
      }
    }
    out.println("</td>");
    out.println("</table>");

    out.printf("<p><a href='list'>사진게시판 목록</a>"
        + "<a href='delete?no=" + board.getNo() + "'>삭제</a>"
        + "<button type='submit'>변경</button>"
        + "</p>");

    out.println("</from>");
    out.println("</body></html>");

  }
}
