package ch21.b;

import java.util.Scanner;

public class Test01 {
  public static void main(String[] args) {
    
    Scanner keyboard = new Scanner(System.in);

      System.out.print("숫자를 입력하세요: ");
      String input = keyboard.nextLine();
      
      try {
        int value = Integer.parseInt(input);
        System.out.println(value % 2 == 0 ? "짝수입니다." : "홀수입니다.");
        return;
      } catch (Exception e) {
        System.out.println("입력 값이 유효하지 않습니다.\n정수 값을 입력하세요!");
        return;
      } finally {
        System.out.println("종료합니다.");
        keyboard.close();
      }
    
  }
}
