package com.eomcs.lms.servlet;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.context.ApplicationContext;
import com.eomcs.lms.domain.Lesson;
import com.eomcs.lms.domain.PhotoBoard;
import com.eomcs.lms.service.LessonService;
import com.eomcs.lms.service.PhotoBoardService;

@SuppressWarnings("serial")
@WebServlet("/photoboard/detail")
public class PhotoBoardDetailServlet extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    PhotoBoardService photoBoardService = 
        ((ApplicationContext) getServletContext().getAttribute("iocContainer")).getBean(PhotoBoardService.class);
    LessonService lessonService = 
        ((ApplicationContext) getServletContext().getAttribute("iocContainer")).getBean(LessonService.class);

    int no = Integer.parseInt(request.getParameter("no"));

    PhotoBoard board = photoBoardService.get(no);

    response.setContentType("text/html;charset=UTF-8");

    if (board == null) {
      request.setAttribute("error.title", "사진 오류");
      request.setAttribute("error.content", "해당 사진을 찾을 수 없습니다.");
      request.getRequestDispatcher("/error.jsp").forward(request, response);
    } else {
      
      List<Lesson> lessons = lessonService.list();
      
      request.setAttribute("board", board);
      request.setAttribute("lessons", lessons);
      request.getRequestDispatcher("/photoboard/detail.jsp").include(request, response);
    }
  }
}
