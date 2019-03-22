package com.eomcs.lms.handler;
import java.util.List;
import org.springframework.stereotype.Component;
import com.eomcs.lms.context.RequestMapping;
import com.eomcs.lms.domain.Board;
import com.eomcs.lms.service.BoardService;

@Component
public class BoardCommand {

  BoardService boardService;

  public BoardCommand(BoardService boardService) {
    this.boardService = boardService;
  }

  @RequestMapping("/board/list")
  public void list(Response response) {
    List<Board> boards = boardService.list();
    response.println("<html><head><title>게시물 목록</title></head>");
    response.println("<body><h1>게시물 목록</h1>");
    response.println("<table border='2' bordercolor='red'>");
    response.println("<tr> <th>번호</th><th>제목</th><th>등록일</th><th>조회</th></tr>");
    for (Board board : boards) {
      response.println(
          String.format("<tr><td>%3d</td> <td>%-20s</td> <td>%s</td> <td>%d</td></tr>", 
              board.getNo(), board.getContents(),
              board.getCreatedDate(), board.getViewCount()));
    }
    response.println("</table></body></html>");
  }

  @RequestMapping("/board/add")
  public void add(Response response) throws Exception {
    Board board = new Board();
    board.setContents(response.requestString("내용?"));
    boardService.add(board);
    response.println("저장하였습니다.");
  }
  
  @RequestMapping("/board/detail")
  public void detail(Response response) throws Exception {
    int no = response.requestInt("번호?");
    Board board = boardService.get(no);
    if (board == null) {
      response.println("해당 번호의 게시물이 없습니다.");
      return;
    }
    response.println(String.format("내용: %s", board.getContents()));
    response.println(String.format("작성일: %s", board.getCreatedDate()));
    response.println(String.format("조회수: %d", board.getViewCount()));
  }
  
  @RequestMapping("/board/update")
  public void update(Response response) throws Exception {
    Board temp = new Board();
    temp.setNo(response.requestInt("번호?"));
    
    String input = response.requestString("내용?");
    if (input.length() > 0)
      temp.setContents(input);
    
    if (temp.getContents() != null) {
      if (boardService.update(temp) == 0) {
        response.println("해당 번호의 게시물이 없습니다.");
        return;
      }
      response.println("변경했습니다.");
      
    } else {
      response.println("변경 취소했습니다.");
    }
  }
  
  @RequestMapping("/board/delete")
  public void delete(Response response) throws Exception {
    int no = response.requestInt("번호?");

    if (boardService.delete(no) == 0) {
      response.println("해당 번호의 게시물이 없습니다.");
      return;
    }
    response.println("삭제했습니다.");
  }
  
}


