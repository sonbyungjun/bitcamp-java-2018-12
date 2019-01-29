package ch21.b;

import java.util.HashMap;
import java.util.Scanner;

public class Test02 {
  public static void main(String[] args) {

    Scanner keyboard = new Scanner(System.in);

    HashMap<String, Command> commandMap = new HashMap<>();
    commandMap.put("plus", new PlusCommand(keyboard));

    while (true) {
      System.out.print("명령> ");
      String input = keyboard.nextLine();
      
      if (input.equals("quit"))
        break;
      
      try {
        Command command = commandMap.get(input);
        command.execute();
        
      } catch (NullPointerException e) {
        System.out.println("해당 명령이 존재하지 않습니다.");
        
      } catch (NumberFormatException e) {
        System.out.println("숫자를 입력하세요.");
        
      }
    }

    System.out.println("실행 완료!");
    keyboard.close();

  }
}
