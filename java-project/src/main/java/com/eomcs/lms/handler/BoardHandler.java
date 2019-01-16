package com.eomcs.lms.handler;

import java.sql.Date;
import java.util.Scanner;
import com.eomcs.lms.domain.Board;

public class BoardHandler {
  
  
  Scanner keyboard;
  
  BoardList boardlist = new BoardList(10);
  
  public BoardHandler(Scanner keyboard) {
    this.keyboard = keyboard;
  }
  
  public void listBoard() {
    boardlist.boards = boardlist.toArray();
    for (int j = 0; j < boardlist.boards.length; j++) {
      System.out.printf("%3d, %-20s, %s, %d\n", 
          boardlist.boards[j].getNo(), boardlist.boards[j].getContents(), boardlist.boards[j].getCreatedDate(), boardlist.boards[j].getViewCount());
    }
  }

  public void addBoard() {
    Board board = new Board();
    
    System.out.print("번호? ");
    board.setNo(Integer.parseInt(this.keyboard.nextLine()));
    
    System.out.print("내용? ");
    board.setContents(this.keyboard.nextLine());
    
    board.setCreatedDate(new Date(System.currentTimeMillis())); 
    
    board.setViewCount(0);
    
    boardlist.add(board);
    
    System.out.println("저장하였습니다.");
  }
  
}
