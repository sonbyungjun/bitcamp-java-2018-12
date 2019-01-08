package ch05;

public class Test02 {
  public static void main(String[] args) {
    int age = 22;

    if (age >= 20) 
      System.out.println("성인입니다.");
    else
      System.out.println("미성년입니다.");

    if (age >= 20) { 
      System.out.println("----------");
      System.out.println("성인입니다.");
    }
    else {
      System.out.println("----------");
      System.out.println("미성년입니다.");
    }
    
    if (age >= 20) { 
      System.out.println("----------");
      System.out.println("성인입니다.");
    } else {
      System.out.println("----------");
      System.out.println("미성년입니다.");
    }
  }
}

