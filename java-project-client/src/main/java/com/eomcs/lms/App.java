package com.eomcs.lms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;
import com.eomcs.lms.context.ApplicationContextListener;
import com.eomcs.lms.handler.Command;

public class App {

  Scanner keyboard = new Scanner(System.in);
  Stack<String> commandHistory = new Stack<>();
  Queue<String> commandHistory2 = new LinkedList<>();
  
  ArrayList<ApplicationContextListener> listeners = new ArrayList<>();
  
  public void addApplicationContextListener(ApplicationContextListener listener) {
    listeners.add(listener);
  }

  public void service() throws Exception {
    
    HashMap<String, Object> context = new HashMap<>();
    context.put("keyboard", keyboard);
    
    for (ApplicationContextListener listener : listeners) {
      listener.contextInitialized(context);
    }
    
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
      
      Command commandHandler = null;
      
      if (!command.startsWith("/")) {
        System.out.println("실행할 수 없는 명령입니다.");
        continue;
      }

      commandHandler = (Command) context.get(command);

      try {
        commandHandler.execute();
        System.out.println();

      } catch (Exception e) {
        System.out.println("명령어 실행 중 오류 발생 : " + e.toString());
      }

    } // while

    keyboard.close();
    
    for (ApplicationContextListener listener : listeners) {
      listener.contextDestroyed(context);
    }
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


  public static void main(String[] args) throws Exception {
    App app = new App();
    
    app.addApplicationContextListener(new ApplicationInitializer());
    // App 을 실행한다.
    app.service();
  }
}
