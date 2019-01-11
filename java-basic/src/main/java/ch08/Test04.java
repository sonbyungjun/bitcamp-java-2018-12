package ch08;

class My4 {
  static int a;
  
  static {
    System.out.println("오호라!");
  }
  
  static {
    System.out.println("이것이 스태틱 블록이네! 여러 개를 선언할 수 있네!");
  }
  
  static void m1() {
    System.out.println("나를 호출하셨군요!!!");
  }
  
}

public class Test04 {
  public static void main(String[] args) {
    System.out.println("*************************");
    
    My4 obj1;
    
    System.out.println("---------------------------");
    
//    My4.a = 300;
    
    My4.m1();
    My4.m1();
    
  }
}
