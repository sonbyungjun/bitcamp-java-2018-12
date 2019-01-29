package design_pattern.command.after;

import java.util.HashMap;
import java.util.Scanner;

public class Test01 {
  public static void main(String[] args) {
    Scanner keyboard = new Scanner(System.in);
    
    HashMap<String, Command> commandMap = new HashMap<>();
    
    commandMap.put("board/add", new BoardAddCommand());
    commandMap.put("board/detail", new BoardDetailCommand());
    commandMap.put("board/list", new BoardListCommand());
    commandMap.put("board/update", new BoardUpdateCommand());
    commandMap.put("board/delete", new BoardDeleteCommand());
    
    commandMap.put("member/add", new MemberAddCommand());
    commandMap.put("member/detail", new MemberDetailCommand());
    commandMap.put("member/list", new MemberListCommand());
    commandMap.put("member/update", new MemberUpdateCommand());
    commandMap.put("member/delete", new MemberDeleteCommand());
    
    commandMap.put("hello", new HelloCommand());
    
    while (true) {
      System.out.printf("명령> ");
      String input = keyboard.nextLine();
      
      Command command = commandMap.get(input);
      
      if (command != null) {
        command.execute();
        
      } else if ("quit".equals(input)) {
        break;
        
      } else {
        System.out.println("처리할 수 없는 명령입니다.");
      }
      System.out.println();
    }
    keyboard.close();
  }
}
