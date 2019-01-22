package com.eomcs.lms.handler;
import java.sql.Date;
import java.util.Scanner;
import com.eomcs.lms.domain.Board;
import com.eomcs.lms.domain.Member;
import com.eomcs.util.ArrayList;

public class BoardHandler {
  
  Scanner keyboard;
  ArrayList<Board> list;
  
  public BoardHandler(Scanner keyboard) {
    this.keyboard = keyboard;
    this.list = new ArrayList<>(20);
  }
  
  public void listBoard() {
    Board[] boards = list.toArray(new Board[] {});
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

  private int indexOf(int no) {
    for (int i = 0; i < list.getSize(); i++) {
      Board board = list.get(i);
      if(board.getNo() == no) 
        return i;
    }
    return -1;
  }

  public void detailBoard() {
    System.out.print("번호? ");
    int index = indexOf(Integer.parseInt(keyboard.nextLine()));
    Board board = list.get(index);
    if (index == -1) {
      System.out.println("해당 게시글을 찾을 수 없습니다.");
      return;
    }
    System.out.printf("내용: %s\n", board.getContents());
    System.out.printf("작성일: %s\n", board.getCreatedDate());
  }


  public void updateBoard() {
    System.out.print("번호? ");
    int index = indexOf(Integer.parseInt(keyboard.nextLine()));
    Board board = list.get(index);
    if (index == -1) {
      System.out.println("해당 게시글을 찾을 수 없습니다.");
      return;
    }
    Board tmp = new Board();
    tmp.setNo(board.getNo());
    System.out.print("내용? ");
    String input = keyboard.nextLine();
    tmp.setContents(input.length() > 0 ? input : board.getContents());
    tmp.setCreatedDate(board.getCreatedDate());
    tmp.setViewCount(board.getViewCount());
    list.set(index, tmp);
    System.out.println("게시글을 변경했습니다.");
  }

  public void deleteBoard() {
    System.out.print("번호? ");
    int index = indexOf(Integer.parseInt(keyboard.nextLine()));
    if (index == -1) {
      System.out.println("해당 게시글을 찾을 수 없습니다.");
      return;
    }
    list.remove(index);
    System.out.println("게시글을 삭제했습니다.");
  }
}
