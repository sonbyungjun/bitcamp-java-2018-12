package ch04;

public class Test05 {
  public static void main(String[] args) {
    float r = 3.2f + 5 / 2;
    System.out.println(r);
    
    float r2 = (3.2f + 5) / 2;
    System.out.println(r2);
    
    int a = 2;
    int r3 = a++ + a++ * a++;
    System.out.println(r3);
    System.out.println(a);
    
  }
}