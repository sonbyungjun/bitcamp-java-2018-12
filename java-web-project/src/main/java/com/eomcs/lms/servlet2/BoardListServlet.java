package com.eomcs.lms.servlet2;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.context.ApplicationContext;
import com.eomcs.lms.domain.Board;
import com.eomcs.lms.service.BoardService;

@SuppressWarnings("serial")
@WebServlet("/board2/list")
public class BoardListServlet extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    
    BoardService boardService = 
        ((ApplicationContext) getServletContext().getAttribute("iocContainer")).getBean(BoardService.class);
    
    List<Board> boards = boardService.list();
    
    PrintWriter out = response.getWriter();
    
    out.println("<h1>게시물 목록</h1>");
    out.println("<p><a href='board2?command=form'>새글</a></p>");
    out.println("<table border='2'>");
    out.println("<tr> <th>번호</th><th>제목</th><th>등록일</th><th>조회</th></tr>");
    for (Board board : boards) {
      out.println(
          String.format("<tr><td>%1$d</td> <td><a href='board2?command=detail&no=%1$d'>%2$s</a></td> <td>%3$s</td> <td>%4$d</td></tr>", 
              board.getNo(), 
              board.getContents(),
              board.getCreatedDate(), 
              board.getViewCount()));
    }
    out.println("</table>");
  }

}


