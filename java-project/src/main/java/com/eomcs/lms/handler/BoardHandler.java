package com.eomcs.lms.handler;

import java.sql.Date;
import java.util.Scanner;
import com.eomcs.lms.domain.Board;

public class BoardHandler {
  
  Scanner keyboard;
  
  BoardList boardlist = new BoardList(20);
  
  public BoardHandler(Scanner keyboard) {
    this.keyboard = keyboard;
  }
  
  public void listBoard() {
    Board[] boards = boardlist.toArray();
    for (Board board : boards) {
      System.out.printf("%3d, %-20s, %s, %d\n", 
          board.getNo(), board.getContents(), board.getCreatedDate(), board.getViewCount());
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
