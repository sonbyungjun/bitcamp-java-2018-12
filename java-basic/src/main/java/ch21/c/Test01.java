package ch21.c;

import java.lang.reflect.Constructor;
import java.util.Scanner;

public class Test01 {
  public static void main(String[] args) {
    Scanner keyboard = new Scanner(System.in);
    
    
    try {
      System.out.print("실행할 Command 클래스 이름을 입력하세요> ");
      String className = keyboard.nextLine();
      Class<?> clazz = Class.forName(className);
      Constructor<?> constructor = clazz.getConstructor(Scanner.class);
      Command command = (Command) constructor.newInstance(keyboard);
      command.execute();
    } catch (ClassNotFoundException e) {
      System.out.println("해당 클래스를 찾지 못했습니다.");
    } catch (NoSuchMethodException e) {
      System.out.println("해당 생성자를 찾지 못했습니다.");
    } catch (ReflectiveOperationException e) {
      System.out.println("기타 예외 발생!");
    } 
    
  }
}
