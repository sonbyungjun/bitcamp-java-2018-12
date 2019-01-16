package ch10;

class My1 {
  static int a;
  
  int b;
}

public class Test01 {
  public static void main(String[] args) {
    My1 obj1 = new My1();
    My1 obj2 = new My1();
    My1 obj3 = new My1();
    
    My1.a = 100;
    
    obj1.a = 200;
    obj2.a = 300;
    obj3.a = 400;
    
    System.out.println(My1.a);
    
    obj1.b = 100;
    obj2.b = 200;
    obj3.b = 300;
    
    System.out.println(obj1.b);
    System.out.println(obj2.b);
    System.out.println(obj3.b);
  }
}
