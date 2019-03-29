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
import com.eomcs.lms.domain.Board;
import com.eomcs.lms.service.BoardService;

@SuppressWarnings("serial")
@WebServlet("/board/list")
public class BoardListServlet extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    
    BoardService boardService = ServerApp.iocContainer.getBean(BoardService.class);
    
    List<Board> boards = boardService.list();
    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();
    out.println("<html><head><title>게시물 목록</title></head>");
    out.println("<body><h1>게시물 목록</h1>");
    out.println("<p><a href='add'>새글</a></p>");
    out.println("<table border='2'>");
    out.println("<tr> <th>번호</th><th>제목</th><th>등록일</th><th>조회</th></tr>");
    for (Board board : boards) {
      out.println(
          String.format("<tr><td>%1$d</td> <td><a href='detail?no=%1$d'>%2$s</a></td> <td>%3$s</td> <td>%4$d</td></tr>", 
              board.getNo(), 
              board.getContents(),
              board.getCreatedDate(), 
              board.getViewCount()));
    }
    out.println("</table></body></html>");
  }

}


