package com.eomcs.lms;

import java.util.Scanner;
import com.eomcs.lms.handler.BoardHandler;
import com.eomcs.lms.handler.LessonHandler;
import com.eomcs.lms.handler.MemberHandler;

public class App {
  
  static Scanner keyboard = new Scanner(System.in);

  public static void main(String[] args) {
    
    BoardHandler board1 = new BoardHandler(keyboard);
    BoardHandler board2 = new BoardHandler(keyboard);
    LessonHandler lesson = new LessonHandler(keyboard);
    MemberHandler member = new MemberHandler(keyboard);
    
    while (true) {
      String command = pompt();

      if (command.equals("/lesson/add")) {
        lesson.addLesson();
        
      } else if (command.equals("/lesson/list")) {
        lesson.listLesson();
      
      } else if (command.equals("/member/add")) {
        member.addMember();
        
      } else if (command.equals("/member/list")) {
        member.listMember();
        
      } else if (command.equals("/board/add")) {
        board1.addBoard();
        
      } else if (command.equals("/board/list")) {
        board1.listBoard();
        
      } else if (command.equals("/board2/add")) {
        board2.addBoard();
        
      } else if (command.equals("/board2/list")) {
        board2.listBoard();
        
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

  static String pompt() {
    System.out.print("명령> ");
    return keyboard.nextLine().toLowerCase();
  }
}
