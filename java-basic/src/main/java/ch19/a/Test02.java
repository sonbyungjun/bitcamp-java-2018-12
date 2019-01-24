package ch19.a;

class Car {
  String model;
  
  public void run() {
    System.out.println("달린다");
  }
  public Car() {
    this.model = "미정";
  }
  public Car(String model) {
    this.model = model;
  }
}

interface Pen {
  void write();
}

public class Test02 {

  static class A {}
  
  class B {}
  
  public static void main(String[] args) {
    class C {}
    
    Car obj = new Car() {
      @Override
      public void run() {
        System.out.println(this.model + " : 달려라! 달려라!");
      }
    };
    obj.run();
    
    Car obj2 = new Car("티코") {
      @Override
      public void run() {
        System.out.println(this.model + " : 경차 달린다!");
      }
    };
    obj2.run();
    
    Pen obj3 = new Pen() {
      @Override
      public void write() {
        System.out.println("글 쓴다!");
      }
    };
    obj3.write();
  }
  
  public static void m1() {
    A obj = new A();
    B obj2; 
    //obj2 = new B();
    //C obj3;
    //obj3 = new C();
  }
  
}
