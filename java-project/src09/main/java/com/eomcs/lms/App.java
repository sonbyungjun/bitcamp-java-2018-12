package com.eomcs.lms;

import java.sql.Date;
import java.util.Scanner;

public class App {
  
  static final int LENGTH = 10;
  
  static Lesson[] lessons = new Lesson[LENGTH];
  static int lessonIdx = 0;
  
  static Member[] members = new Member[LENGTH];
  static int memberIdx = 0;
  
  static Board[] boards = new Board[LENGTH];
  static int boardIdx = 0;

  static Scanner keyboard = new Scanner(System.in);
  
  public static void main(String[] args) {

    while (true) {
      String command = prompt();

      if (command.equals("/lesson/add")) {
        
        Lesson lesson = Lesson.addLesson();
        lessons[lessonIdx] = lesson;
        lessonIdx++;
        System.out.println("저장하였습니다.");
        
      } else if (command.equals("/lesson/list")) {
        
        Lesson.listLesson();
      
      } else if (command.equals("/member/add")) {
        
        Member member = Member.addMember();
        members[memberIdx] = member;
        memberIdx++;
        System.out.println("저장하였습니다.");
        
      } else if (command.equals("/member/list")) {
        
        Member.listMember();
        
      } else if (command.equals("/board/add")) {
        
        Board board = new Board();
        boards[boardIdx] = board;
        boardIdx++;
        System.out.println("저장하였습니다.");
        
      } else if (command.equals("/board/list")) {
        
        Board.listBoard();
        
      } else if (command.equals("quit")) {
        
        System.out.println("안녕!");
        break;
        
      } else {
        System.out.println("실행할 수 없는 명령입니다.");
      }
      
      System.out.println(); // 결과 출력 후 빈 줄 출력
    }

    keyboard.close();
  }
  
  static String prompt() {
    System.out.print("명령> ");
    return keyboard.nextLine();
  }
  
}
