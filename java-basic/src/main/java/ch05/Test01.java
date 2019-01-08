package ch05;

public class Test01 {
  public static void main(String[] args) {
    int age = 19;
    
    if (age >= 20) System.out.println("성인입니다.");
    
    if (age >= 20)
      System.out.println("성인입니다.");
    
    if (age >= 20) {
      System.out.print("성인");
      System.out.println("입니다.");
    }
    System.out.println("-------------------------");
    
    if (age >= 20)
      System.out.print("성인");
      System.out.println("입니다.");
  }
}
