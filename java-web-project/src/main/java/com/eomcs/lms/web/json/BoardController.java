package com.eomcs.lms.web.json;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.eomcs.lms.domain.Board;
import com.eomcs.lms.service.BoardService;

@RestController("json/BoardController")
@RequestMapping("/json/board")
public class BoardController {
  
  @Autowired
  BoardService boardService;
  
  @PostMapping("add")
  public String add(Board board) {
    boardService.add(board);
    return "redirect:.";
  }
  
  @GetMapping("delete/{no}")
  public String delete(@PathVariable int no) {
    if (boardService.delete(no) == 0) {
      throw new RuntimeException("해당 게시물이 없습니다.");
    }
    return "redirect:../";
  }
  
  @GetMapping("{no}")
  public String detail(@PathVariable int no, Model model) {
    Board board = boardService.get(no);
    model.addAttribute("board", board);
    return "board/detail";
  }
  
  @GetMapping("list")
  public void list(
      @RequestParam(defaultValue="1") int pageNo,
      @RequestParam(defaultValue="3") int pageSize,
      Model model) {
    
    if (pageSize < 3 || pageSize > 8) 
      pageSize = 3;
    
    int rowsCount = boardService.size();
    int totalPage = rowsCount / pageSize;
    
    if (rowsCount % pageSize > 0) 
      totalPage++;

    if (pageNo < 1) 
      pageNo = 1;
    else if (pageNo > totalPage)
      pageNo = totalPage;
    
    List<Board> boards = boardService.list(pageNo, pageSize);
    model.addAttribute("list", boards);
    model.addAttribute("pageNo", pageNo);
    model.addAttribute("pageSize", pageSize);
    model.addAttribute("totalPage", totalPage);
  }
  
  @PostMapping("update")
  public String update(Board board) {
    if (boardService.update(board) == 0) 
      throw new RuntimeException("해당 번호의 게시물이 없습니다.");
    return "redirect:.";
  }
}


