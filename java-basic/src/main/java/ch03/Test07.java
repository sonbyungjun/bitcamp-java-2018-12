package ch03;

public class Test07 {
  public static void main(String[] args) {
    java.util.Scanner keyboard = new java.util.Scanner(System.in);

    System.out.println("이름을 입력하세요:");
    java.lang.String name = keyboard.nextLine();
    
    System.out.println("나이를 입력하세요:");
    java.lang.String age = keyboard.nextLine();

    System.out.printf("%s(%s)\n", name, age);
  }
}
