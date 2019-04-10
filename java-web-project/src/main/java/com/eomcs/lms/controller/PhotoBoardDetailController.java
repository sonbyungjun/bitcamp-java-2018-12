package com.eomcs.lms.controller;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import com.eomcs.lms.domain.Lesson;
import com.eomcs.lms.domain.PhotoBoard;
import com.eomcs.lms.service.LessonService;
import com.eomcs.lms.service.PhotoBoardService;

@Controller("/photoboard/detail")
public class PhotoBoardDetailController implements PageController {

  @Autowired
  PhotoBoardService photoBoardService;

  @Autowired
  LessonService lessonService;
  
  
  @Override
  public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

    int no = Integer.parseInt(request.getParameter("no"));

    PhotoBoard board = photoBoardService.get(no);

    if (board == null) {
      throw new Exception("해당 번호의 사진을 찾을 수 없습니다.");
    } else {
      List<Lesson> lessons = lessonService.list();
      request.setAttribute("board", board);
      request.setAttribute("lessons", lessons);
      return "/photoboard/detail.jsp";
    }
  }
}
