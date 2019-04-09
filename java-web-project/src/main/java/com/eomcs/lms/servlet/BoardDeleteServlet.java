package com.eomcs.lms.servlet;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.context.ApplicationContext;
import com.eomcs.lms.service.BoardService;

@SuppressWarnings("serial")
@WebServlet("/board/delete")
public class BoardDeleteServlet extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    BoardService boardService = 
        ((ApplicationContext) getServletContext().getAttribute("iocContainer")).getBean(BoardService.class);
    int no = Integer.parseInt(request.getParameter("no"));

    if (boardService.delete(no) > 0) {
      request.setAttribute("viewUrl", "redirect:list");
    } else {
      request.setAttribute("error.title", "게시물 삭제");
      request.setAttribute("error.content", "해당 번호의 게시물이 없습니다.");
    }
  }
}


