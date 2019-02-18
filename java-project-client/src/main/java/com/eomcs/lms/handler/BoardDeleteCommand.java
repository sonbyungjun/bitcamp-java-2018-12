package com.eomcs.lms.handler;
import java.util.Scanner;
import com.eomcs.lms.Dao.BoardDao;

public class BoardDeleteCommand implements Command {

  Scanner keyboard;
  BoardDao boardDao;

  public BoardDeleteCommand(Scanner keyboard, BoardDao boardDao) {
    this.keyboard = keyboard;
    this.boardDao = boardDao;
  }
  
  @Override
  public void execute() {
    System.out.print("번호? ");
    int no = Integer.parseInt(keyboard.nextLine());

    try {
      boardDao.delete(no);
      System.out.println("게시글을 삭제했습니다.");

    } catch (Exception e) {
      System.out.printf("게시글 삭제 오류! : %s\n", e.getMessage());
    }

  }

}
