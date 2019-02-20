package com.eomcs.lms;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;
import com.eomcs.lms.Dao.BoardDaoImpl;
import com.eomcs.lms.Dao.LessonDaoImpl;
import com.eomcs.lms.Dao.MemberDaoImpl;
import com.eomcs.lms.handler.BoardAddCommand;
import com.eomcs.lms.handler.BoardDeleteCommand;
import com.eomcs.lms.handler.BoardDetailCommand;
import com.eomcs.lms.handler.BoardListCommand;
import com.eomcs.lms.handler.BoardUpdateCommand;
import com.eomcs.lms.handler.Command;
import com.eomcs.lms.handler.LessonAddCommand;
import com.eomcs.lms.handler.LessonDeleteCommand;
import com.eomcs.lms.handler.LessonDetailCommand;
import com.eomcs.lms.handler.LessonListCommand;
import com.eomcs.lms.handler.LessonUpdateCommand;
import com.eomcs.lms.handler.MemberAddCommand;
import com.eomcs.lms.handler.MemberDeleteCommand;
import com.eomcs.lms.handler.MemberDetailCommand;
import com.eomcs.lms.handler.MemberListCommand;
import com.eomcs.lms.handler.MemberUpdateCommand;

public class App {

  Scanner keyboard = new Scanner(System.in);
  Stack<String> commandHistory = new Stack<>();
  Queue<String> commandHistory2 = new LinkedList<>();

  public void service() {

    Map<String,Command> commandMap = new HashMap<>();

//    LessonDaoImpl lessonAgent = new LessonDaoImpl();
//    commandMap.put("/lesson/add", new LessonAddCommand(keyboard, lessonAgent));
//    commandMap.put("/lesson/list", new LessonListCommand(keyboard, lessonAgent));
//    commandMap.put("/lesson/detail", new LessonDetailCommand(keyboard, lessonAgent));
//    commandMap.put("/lesson/update", new LessonUpdateCommand(keyboard, lessonAgent));
//    commandMap.put("/lesson/delete", new LessonDeleteCommand(keyboard, lessonAgent));
//
//    MemberDaoImpl memberAgent = new MemberDaoImpl();
//    commandMap.put("/member/add", new MemberAddCommand(keyboard, memberAgent));
//    commandMap.put("/member/list", new MemberListCommand(keyboard, memberAgent));
//    commandMap.put("/member/detail", new MemberDetailCommand(keyboard, memberAgent));
//    commandMap.put("/member/update", new MemberUpdateCommand(keyboard, memberAgent));
//    commandMap.put("/member/delete", new MemberDeleteCommand(keyboard, memberAgent));

    BoardDaoImpl boardAgent = new BoardDaoImpl();
    commandMap.put("/board/add", new BoardAddCommand(keyboard, boardAgent));
    commandMap.put("/board/list", new BoardListCommand(keyboard, boardAgent));
    commandMap.put("/board/detail", new BoardDetailCommand(keyboard, boardAgent));
    commandMap.put("/board/update", new BoardUpdateCommand(keyboard, boardAgent));
    commandMap.put("/board/delete", new BoardDeleteCommand(keyboard, boardAgent));

    while (true) {


      String command = prompt();

      commandHistory.push(command);
      commandHistory2.offer(command);

      if (command.equals("quit")) {
        System.out.println("종료합니다.");
        break;

      } else if (command.equals("history")) {
        printCommandHistory();
        continue;

      } else if (command.equals("history2")) {
        printCommandHistory2();
        continue;
      } 

      Command commandHandler = commandMap.get(command);

      if (commandHandler == null) {
        System.out.println("실행할 수 없는 명령입니다.");
        continue;
      } 

      try {
        commandHandler.execute();
        System.out.println();

      } catch (Exception e) {
        System.out.println("명령어 실행 중 오류 발생 : " + e.toString());
      }

    } // while

    keyboard.close();
  }

  @SuppressWarnings("unchecked")
  private void printCommandHistory() {
    Stack<String> temp = (Stack<String>) commandHistory.clone();

    while (temp.size() > 0) {
      System.out.println(temp.pop());
    }
  }

  @SuppressWarnings("unchecked")
  private void printCommandHistory2() {
    Queue<String> temp = (Queue<String>) ((LinkedList<String>) commandHistory2).clone();

    while (temp.size() > 0) {
      System.out.println(temp.poll());
    }
  }

  private String prompt() {
    System.out.print("명령> ");
    return keyboard.nextLine().toLowerCase();
  }


  public static void main(String[] args) {
    App app = new App();

    // App 을 실행한다.
    app.service();
  }
}
