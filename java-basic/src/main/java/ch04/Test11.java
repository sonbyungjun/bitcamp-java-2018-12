package ch04;

public class Test11 {
  public static void main(String[] args) {
    System.out.println(true & true);
    System.out.println(true & false);
    
    System.out.println(true | false);
    System.out.println(false | false);
    
    int a = 0xca;
    int b = 0x66;
    System.out.println(a & b);
    
    System.out.println(a | b);
  }
}
