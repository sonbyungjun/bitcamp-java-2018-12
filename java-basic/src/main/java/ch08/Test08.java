package ch08;

import java.util.Scanner;

public class Test08 {
  public static void main(String[] args) {
    Scanner keyboard = new Scanner(System.in);

    System.out.print("계산식?(예 : 12 * 2)  ");
    int a = keyboard.nextInt();
    String op = keyboard.next();
    int b = keyboard.nextInt();

    keyboard.close();

    int result = 0;

    switch (op) {
      case "+": result = ch08.util.Calculrator2.plus(a, b); break;
      case "-": result = ch08.util.Calculrator2.minus(a, b); break;
      case "*": result = ch08.util.Calculrator2.multiple(a, b); break;
      case "/": result = ch08.util.Calculrator2.divide(a, b); break;
      default:
        System.out.println("지원하지 않는 연산자입니다.");
        return;
    }
    System.out.printf("%d %s %d = %d\n", a , op, b, result);
  }

  
}