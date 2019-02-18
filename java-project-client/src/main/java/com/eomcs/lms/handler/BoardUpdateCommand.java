package com.eomcs.lms.handler;
import java.util.Scanner;
import com.eomcs.lms.Dao.BoardDao;
import com.eomcs.lms.domain.Board;

public class BoardUpdateCommand implements Command {

  Scanner keyboard;
  BoardDao boardDao;

  public BoardUpdateCommand(Scanner keyboard, BoardDao boardDao) {
    this.keyboard = keyboard;
    this.boardDao = boardDao;
  }

  @Override
  public void execute() {
    System.out.print("번호? ");
    int no = Integer.parseInt(keyboard.nextLine());

    try {
      Board board = boardDao.findByNo(no);
      // 기존 값 복제
      Board temp = board.clone();
      
      System.out.printf("내용? ");
      String input = keyboard.nextLine();
      if (input.length() > 0) 
        temp.setContents(input);
      
      boardDao.update(temp);
      
      System.out.println("게시글을 변경했습니다.");

    } catch (Exception e) {
      System.out.printf("게시글 변경 오류! : %s\n", e.getMessage());
    }
  }

}
