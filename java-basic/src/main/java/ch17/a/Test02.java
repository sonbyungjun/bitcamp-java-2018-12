package ch17.a;

abstract class My1 extends A {
  
}

class My2 extends A {

  @Override
  public void m2(String value) {
    System.out.println("My2.m2() - " + value);
  }
  
  public void m3() {
    System.out.println("Hello!");
  }
}

public class Test02 {
  public static void main(String[] args) {
    My2 obj3 = new My2();
    obj3.m2("홍길동");
    
    A obj4 = new My2();
    
    obj4.m2("임꺽정");
    
//    obj4.m3();
    
    ((My2) obj4).m3();
    
    
  }
}
