package ch03;

public class Test06 {
  public static void main(String[] args) {
    java.io.InputStream in = System.in;
    java.util.Scanner keyboard = new java.util.Scanner(in);

    System.out.println("이름을 입력하세요:");

    java.lang.String str = keyboard.nextLine();

    System.out.printf("당신의 이름은 %s 입니다.\n", str);
  }
}
