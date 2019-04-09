package com.eomcs.lms.servlet;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.context.ApplicationContext;
import com.eomcs.lms.service.PhotoBoardService;

@SuppressWarnings("serial")
@WebServlet("/photoboard/delete")
public class PhotoBoardDeleteServlet extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    PhotoBoardService photoBoardService = 
        ((ApplicationContext) getServletContext().getAttribute("iocContainer")).getBean(PhotoBoardService.class);

    int no = Integer.parseInt(request.getParameter("no"));

    if (photoBoardService.delete(no) > 0) {
      request.setAttribute("viewUrl", "redirect:list");
      
    } else {
      request.setAttribute("error.title", "사진게시판 삭제");
      request.setAttribute("error.content", "해당 번호의 사진게시판이 없습니다.");
    }
  }
}
