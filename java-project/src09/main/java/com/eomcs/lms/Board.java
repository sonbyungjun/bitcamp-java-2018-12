package com.eomcs.lms;

import java.sql.Date;
import java.util.Scanner;

public class Board {
  int no;
  String contents;
  Date createdDate;
  int viewCount;
  
  static Scanner keyboard = new Scanner(System.in);
  
  static Board addBoard() {
    
    Board board = new Board();
    
    System.out.print("번호? ");
    board.no = Integer.parseInt(keyboard.nextLine());
    
    System.out.print("내용? ");
    board.contents = keyboard.nextLine();
    
    board.createdDate = new Date(System.currentTimeMillis()); 
    
    board.viewCount = 0;
    
    return board;
  }
  
  static void listBoard() {
    for (int j = 0; j < App.boardIdx; j++) {
      System.out.printf("%3d, %-20s, %s, %d\n", 
          App.boards[j].no, App.boards[j].contents, App.boards[j].createdDate, App.boards[j].viewCount);
    }
  }
}
