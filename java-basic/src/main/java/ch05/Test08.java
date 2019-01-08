package ch05;

public class Test08 {
  public static void main(String[] args) {
    int a = 1;
    while (a <= 10) System.out.print(a++ + " ");
    
    System.out.println();
    
    a = 1;
    while (a <= 10) 
      System.out.print(a++ + " ");
    
    System.out.println();
    
    a = 1;
    while (a <= 10) { 
      System.out.print(a + " ");
      a++;
    }
  }
}