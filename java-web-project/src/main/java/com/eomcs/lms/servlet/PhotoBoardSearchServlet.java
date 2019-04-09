package com.eomcs.lms.servlet;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.context.ApplicationContext;
import com.eomcs.lms.domain.PhotoBoard;
import com.eomcs.lms.service.PhotoBoardService;

@SuppressWarnings("serial")
@WebServlet("/photoboard/search")
public class PhotoBoardSearchServlet extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    PhotoBoardService photoBoardService = 
        ((ApplicationContext) getServletContext().getAttribute("iocContainer")).getBean(PhotoBoardService.class);

    request.setCharacterEncoding("UTF-8");

    int lessonNo = 0;
    try {
      lessonNo = Integer.parseInt(request.getParameter("lessonNo"));
    } catch (Exception e) { // 수업 번호를 입력하지 않거나 정상 입력이 아닌 경우는 무시한다.
    }

    String searchWord = null;
    try {
      String keyword = request.getParameter("keyword");
      if (keyword.length() > 0)
        searchWord = keyword;
    } catch (Exception e) { // 사용자가 검색어를 입력하지 않았으면 무시한다.
    }

    List<PhotoBoard> boards = photoBoardService.list(lessonNo, searchWord);
    request.setAttribute("list", boards);
    request.setAttribute("viewUrl", "/photoboard/list.jsp");

  }
}
