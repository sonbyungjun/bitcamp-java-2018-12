package ch08;

import java.util.Scanner;

public class Test06 {
  public static void main(String[] args) {
    Scanner keyboard = new Scanner(System.in);

    System.out.print("계산식?(예 : 12 * 2)  ");
    int a = keyboard.nextInt();
    String op = keyboard.next();
    int b = keyboard.nextInt();

    keyboard.close();

    int result = 0;

    switch (op) {
      case "+": result = plus(a, b); break;
      case "-": result = minus(a, b); break;
      case "*": result = multiple(a, b); break;
      case "/": result = divide(a, b); break;
      default:
        System.out.println("지원하지 않는 연산자입니다.");
        return;
    }
    System.out.printf("%d %s %d = %d\n", a , op, b, result);
  }

  static int plus(int a, int b) {
    return a + b;
  }

  static int minus(int a, int b) {
    return a - b;
  }

  static int multiple(int a, int b) {
    return a * b;
  }

  static int divide(int a, int b) {
    return a / b;
  }
}