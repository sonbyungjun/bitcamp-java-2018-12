package ch14.e;

public class Test01 {

  public static void main(String[] args) {
    PickupTruck c1 = new PickupTruck();
    SUV c2 = new SUV();
    Convertible c3 = new Convertible();
    DumpTruck c4 = new DumpTruck();
    
    test(c1);
    test(c2);
    test(c3);
    test(c4);
  }
  
  static void test(PickupTruck car) {
    System.out.println("-------------------");
    car.run();
    car.stop();
    car.run();
    car.stop();
    System.out.println("-------------------");
  }
  static void test(SUV car) {
    System.out.println("-------------------");
    car.run();
    car.stop();
    car.run();
    car.stop();
    System.out.println("-------------------");
  }
  static void test(Convertible car) {
    System.out.println("-------------------");
    car.run();
    car.stop();
    car.run();
    car.stop();
    System.out.println("-------------------");
  }
  static void test(DumpTruck car) {
    System.out.println("-------------------");
    car.run();
    car.stop();
    car.run();
    car.stop();
    System.out.println("-------------------");
  }
  
  
}
