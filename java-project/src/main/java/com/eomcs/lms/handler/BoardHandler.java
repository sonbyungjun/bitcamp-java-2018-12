package com.eomcs.lms.handler;
import java.sql.Date;
import java.util.Scanner;
import com.eomcs.lms.domain.Board;
import com.eomcs.util.ArrayList;

public class BoardHandler {

  Scanner keyboard;
  ArrayList<Board> list;

  public BoardHandler(Scanner keyboard) {
    this.keyboard = keyboard;
    this.list = new ArrayList<>(20);
  }

  public void listBoard() {
    Board[] boards = list.toArray(new Board[0]);
    for (Board board : boards) {
      System.out.printf("%3d, %-20s, %s, %d\n", 
          board.getNo(), board.getContents(), 
          board.getCreatedDate(), board.getViewCount());
    }
  }

  public void addBoard() {
    Board board = new Board();

    System.out.print("번호? ");
    board.setNo(Integer.parseInt(keyboard.nextLine()));

    System.out.print("내용? ");
    board.setContents(keyboard.nextLine());

    board.setCreatedDate(new Date(System.currentTimeMillis())); 

    board.setViewCount(0);

    list.add(board);

    System.out.println("저장하였습니다.");
  }

  public void datailBoard() {
    System.out.print("번호? ");
    int no = Integer.parseInt(keyboard.nextLine());
    int i = indexOfBoard(no);
    Board board = list.get(i);
    if (i == -1) {
      System.out.println("해당 게시글을 찾을 수 없습니다.");
      return;
    }
    System.out.printf("내용: %s\n", board.getContents());
    System.out.printf("작성일: %s\n", board.getCreatedDate());
  }
  
  public void updateBoard() {
    System.out.print("번호? ");
    int no = Integer.parseInt(keyboard.nextLine());
    int i = indexOfBoard(no);
    Board board = list.get(i);
    if (i == -1) {
      System.out.println("해당 게시글을 찾을 수 없습니다.");
      return;
    }
    System.out.print("내용? ");
    String cmd = keyboard.nextLine();
    if (cmd.equals("")) {
      list.set(i, board);
    } else {
      board.setContents(cmd);
      list.set(i, board);
    }
    System.out.println("게시글을 변경했습니다.");
  }
  
  public void deleteBoard() {
    System.out.print("번호? ");
    int no = Integer.parseInt(keyboard.nextLine());
    int i = indexOfBoard(no);
    if (i == -1) {
      System.out.println("해당 게시글을 찾을 수 없습니다.");
      return;
    }
    list.delete(i);
    System.out.println("게시글을 삭제했습니다.");
  }
  
  
  private int indexOfBoard(int index) {
    for (int i = 0; i < list.getSize(); i++) {
      Board board = list.get(i);
      if (board.getNo() == index)
        return i;
    }
    return -1;
  }
  

}


