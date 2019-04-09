package com.eomcs.lms.servlet;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.context.ApplicationContext;
import com.eomcs.lms.domain.Board;
import com.eomcs.lms.service.BoardService;

@SuppressWarnings("serial")
@WebServlet("/board/add")
public class BoardAddServlet extends HttpServlet{

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    request.setAttribute("viewUrl", "/board/form.jsp");
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    BoardService boardService = 
        ((ApplicationContext) getServletContext().getAttribute("iocContainer"))
        .getBean(BoardService.class);

    Board board = new Board();
    board.setContents(request.getParameter("contents")
        + " : " + request.getRemoteAddr());
    
    if (request.getParameter("contents").length() == 0) {
      request.setAttribute("error.title", "게시글 입력 오류");
      request.setAttribute("error.content", "게시글을 입력해주세요.");
      return;
    }

    boardService.add(board);
    request.setAttribute("viewUrl", "redirect:list");
  }

}


