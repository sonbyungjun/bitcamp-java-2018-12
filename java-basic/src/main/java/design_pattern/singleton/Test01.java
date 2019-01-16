package design_pattern.singleton;

class Car1 {
  String model;
  int cc;
  
  public Car1() {}

}

public class Test01 {
  public static void main(String[] args) {
    Car1 c1 = new Car1();
    Car1 c2 = new Car1();
    
    if (c1 != c2) {
      System.out.println("다르다");
    }
  }
}
