package ch03;

public class Test04 {
  public static void main(String[] args) {
    int a = 100;
    int b = a;
    System.out.printf("%d, %d\n", a, b);
    
    a = 200;
    System.out.printf("%d, %d\n", a, b);
    
    a = 300;
    a = b;
    
    
  }
}
