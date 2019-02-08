package com.eomcs.lms;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;
import com.eomcs.lms.context.ApplicationListener;
import com.eomcs.lms.domain.Board;
import com.eomcs.lms.domain.Lesson;
import com.eomcs.lms.domain.Member;
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
import com.eomcs.lms.listner.BoardDataLoderListener;
import com.eomcs.lms.listner.LessonDataLoderListener;
import com.eomcs.lms.listner.MemberDataLoderListener;

public class App {

  static ArrayList<ApplicationListener> observers = new ArrayList<>();
  static HashMap<String, Object> context = new HashMap<>();
  
  static {
    context.put("keyboard", new Scanner(System.in));
    context.put("commandHistory", new Stack<String>());
    context.put("commandHistory2", new LinkedList<String>());
    context.put("lessonList", new ArrayList<Lesson>());
    context.put("memberList", new LinkedList<Member>());
    context.put("boardList", new ArrayList<Board>());
  }
  
  static void addApplicationListener(ApplicationListener listener) {
    observers.add(listener);
  }
  
  @SuppressWarnings("unchecked")
  public static void main(String[] args) {
    
    addApplicationListener(new BoardDataLoderListener());
    addApplicationListener(new MemberDataLoderListener());
    addApplicationListener(new LessonDataLoderListener());
    
    for (ApplicationListener observer : observers) {
      try {
        observer.startApplication(context);
      } catch (Exception e) {}
    }
    
    Map<String,Command> commandMap = new HashMap<>();

    Scanner keyboard = (Scanner) context.get("keyboard");
    ArrayList<Lesson> lessonList = (ArrayList<Lesson>) context.get("lessonList");
    commandMap.put("/lesson/add", new LessonAddCommand(keyboard, lessonList));
    commandMap.put("/lesson/list", new LessonListCommand(keyboard, lessonList));
    commandMap.put("/lesson/detail", new LessonDetailCommand(keyboard, lessonList));
    commandMap.put("/lesson/update", new LessonUpdateCommand(keyboard, lessonList));
    commandMap.put("/lesson/delete", new LessonDeleteCommand(keyboard, lessonList));

    LinkedList<Member> memberList = (LinkedList<Member>) context.get("memberList");
    commandMap.put("/member/add", new MemberAddCommand(keyboard, memberList));
    commandMap.put("/member/list", new MemberListCommand(keyboard, memberList));
    commandMap.put("/member/detail", new MemberDetailCommand(keyboard, memberList));
    commandMap.put("/member/update", new MemberUpdateCommand(keyboard, memberList));
    commandMap.put("/member/delete", new MemberDeleteCommand(keyboard, memberList));

    ArrayList<Board> boardList = (ArrayList<Board>) context.get("boardList");
    commandMap.put("/board/add", new BoardAddCommand(keyboard, boardList));
    commandMap.put("/board/list", new BoardListCommand(keyboard, boardList));
    commandMap.put("/board/detail", new BoardDetailCommand(keyboard, boardList));
    commandMap.put("/board/update", new BoardUpdateCommand(keyboard, boardList));
    commandMap.put("/board/delete", new BoardDeleteCommand(keyboard, boardList));

    
    Stack<String> commandHistory = (Stack<String>) context.get("commandHistory");
    Queue<String> commandHistory2 = (Queue<String>) context.get("commandHistory2");
    
    while (true) {
      String command = prompt();

      // 사용자가 입력한 명령을 스택에 보관한다.
      commandHistory.push(command);

      // 사용자가 입력한 명령을 큐에 보관한다.
      commandHistory2.offer(command);

      // 사용자가 입력한 명령으로 Command 객체를 찾는다.
      Command commandHandler = commandMap.get(command);

      if (commandHandler != null) {
        try {
          commandHandler.execute();
        } catch (Exception e) {
          System.out.println("명령어 실행 중 오류 발생 : " + e.toString());
        }
      } else if (command.equals("quit")) {
        System.out.println("안녕!");
        break;

      } else if (command.equals("history")) {
        printCommandHistory();

      } else if (command.equals("history2")) {
        printCommandHistory2();

      } else {
        System.out.println("실행할 수 없는 명령입니다.");
      }

      System.out.println(); 
    }

    keyboard.close();
  
    for (ApplicationListener observer : observers) {
      try {
        observer.endApplication(context);
      } catch (Exception e) {}
    }
    
  }

  @SuppressWarnings("unchecked")
  private static void printCommandHistory() {
    Stack<String> commandHistory = (Stack<String>) context.get("commandHistory");
    Stack<String> temp = (Stack<String>) commandHistory.clone();

    while (temp.size() > 0) {
      System.out.println(temp.pop());
    }
  }

  @SuppressWarnings("unchecked")
  private static void printCommandHistory2() {
    Queue<String> commandHistory2 = (Queue<String>) context.get("commandHistory2");
    Queue<String> temp = (Queue<String>) ((LinkedList<String>) commandHistory2).clone();

    while (temp.size() > 0) {
      System.out.println(temp.poll());
    }
  }

  private static String prompt() {
    Scanner keyboard = (Scanner) context.get("keyboard");
    System.out.print("명령> ");
    return keyboard.nextLine().toLowerCase();
  }
  
}
