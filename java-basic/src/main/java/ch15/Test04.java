package ch15;

class My4 {
  String name;
  int age;
  
}

public class Test04 {
  public static void main(String[] args) {
    My4 obj1 = new My4();
    obj1.name = "홍길동";
    obj1.age = 20;
    
    My4 obj2 = new My4();
    obj2.name = "홍길동";
    obj2.age = 20;
    
    System.out.println(obj1 == obj2);
    System.out.println(obj1.equals(obj2));
    
    
  }
}
