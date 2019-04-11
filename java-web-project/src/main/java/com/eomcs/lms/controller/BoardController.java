package com.eomcs.lms.controller;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.eomcs.lms.domain.Board;
import com.eomcs.lms.service.BoardService;

@Controller
public class BoardController {

  @Autowired
  BoardService boardService;
  
  @RequestMapping("/board/form")
  public String form() throws Exception {
    return "/board/form.jsp";
  }
  
  @RequestMapping("/board/add")
  public String add(Board board) throws Exception {
    boardService.add(board);
    return "redirect:list";
  }
  
  @RequestMapping("/board/delete")
  public String delete(@RequestParam("no") int no) throws Exception {
    if (boardService.delete(no) == 0) 
      throw new Exception("해당 번호의 게시물이 없습니다.");
    return "redirect:list";
  }
  
  @RequestMapping("/board/detail")
  public String detail(@RequestParam("no") int no, Map<String,Object> map) throws Exception {
    Board board = boardService.get(no);
    map.put("board", board);
    return "/board/detail.jsp";
  }
  
  @RequestMapping("/board/list")
  public String list(Map<String,Object> map) throws Exception {
    List<Board> boards = boardService.list();
    map.put("list", boards);
    return "/board/list.jsp";
  }
  
  @RequestMapping("/board/update")
  public String update(Board board) throws Exception {
    if (boardService.update(board) == 0) 
      throw new Exception("해당 번호의 게시물이 없습니다.");
    return "redirect:list";
  }
  
}


