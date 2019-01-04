package ch03;

public class Test08 {
  public static void main(String[] args) {
    java.util.Scanner keyboard = new java.util.Scanner(System.in);

    System.out.print("a? ");
    int a = keyboard.nextInt();
    
    System.out.print("b? ");
    int b = keyboard.nextInt();

    System.out.printf("%d * %d = %d\n", a, b, a * b);
  }
}
