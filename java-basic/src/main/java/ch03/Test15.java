package ch03;

public class Test15 {
  public static void main(String[] args) {
    int a = 100;
    {
//      int a = 200;
      
      System.out.println("=>" + a);
      int b = 200;
      System.out.println("=>" + b);
    }
    System.out.println(a);
//    System.out.println(b);
  }
}
