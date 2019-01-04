package ch03;

public class Test09 {
  public static void main(String[] args) {
    java.util.Scanner keyboard = new java.util.Scanner(System.in);

    System.out.print("나이? ");
    int age = keyboard.nextInt();
    keyboard.nextLine();
    
    System.out.print("이름? ");
    String name = keyboard.nextLine();

    System.out.printf("%d(%s)\n", age, name);
  }
}
