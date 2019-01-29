package ch21.b;

import java.util.HashMap;
import java.util.Scanner;

public class Test03 {
  public static void main(String[] args) {

    Scanner keyboard = new Scanner(System.in);

    HashMap<String, Command> commandMap = new HashMap<>();
    commandMap.put("plus", new PlusCommand(keyboard));
    commandMap.put("divide", new DivideCommand(keyboard));

    while (true) {
      System.out.print("명령> ");
      String input = keyboard.nextLine();

      if (input.equals("quit"))
        break;

      try {
        Command command = commandMap.get(input);
        command.execute();

      } catch (RuntimeException e) {
//      } catch (Exception e) {
        System.out.println("명령어 처리 중 오류 발생!");
        System.out.println(e.toString());

      } 

    }

    System.out.println("실행 완료!");
    keyboard.close();

  }
}
