package ch15;

class My3 {
  String name;
  int age;
  
  @Override
  public String toString() {
    return "My3 [name=" + name + ", age=" + age + "]";
  }
  
  
}

public class Test03 {
  public static void main(String[] args) {
    My3 obj1 = new My3();
    obj1.name = "홍길동";
    obj1.age = 20;
    System.out.println(obj1.toString());
    System.out.println(obj1);
  }
}
