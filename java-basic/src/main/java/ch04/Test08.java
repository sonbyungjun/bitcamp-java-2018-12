package ch04;

public class Test08 {
  public static void main(String[] args) {
    int a = 5;
    int r = ++a;
    System.out.printf("%d, %d\n", a, r);
    
    a = 5;
    r = --a;
    System.out.printf("%d, %d\n", a, r);
    
    a = 5;
    r = --a + --a / --a;
    System.out.printf("%d, %d\n", a, r);
  }
}
