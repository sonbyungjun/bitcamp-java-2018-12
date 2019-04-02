package com.eomcs.lms.servlet3;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.context.ApplicationContext;
import com.eomcs.lms.domain.Board;
import com.eomcs.lms.service.BoardService;

@SuppressWarnings("serial")
@WebServlet("/board3/update")
public class BoardUpdateServlet extends HttpServlet {

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    
    BoardService boardService = 
        ((ApplicationContext) getServletContext().getAttribute("iocContainer")).getBean(BoardService.class);
    
    Board board = new Board();
    board.setNo(Integer.parseInt(request.getParameter("no")));
    board.setContents(request.getParameter("contents"));
    
    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();

    out.println("<html><head>"
        + "<title>게시물 변경</title>"
        + "<meta http-equiv='Refresh' content='1;url=list'>"
        + "</head>");
    
    out.println("<body>");
    
    request.getRequestDispatcher("/board3/header").include(request, response);
    
    out.println("<h1>게시물 변경</h1>");

    if (boardService.update(board) == 0) {
      out.println("<p>해당 번호의 게시물이 없습니다.</p>");
    } else {
      out.println("<p>변경했습니다.</p>");
    }
    
    request.getRequestDispatcher("/board3/footer").include(request, response);
    
    out.println("</body></html>");

  }
}


