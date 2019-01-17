package ch14.e;

public class Test03 {

  public static void main(String[] args) {
    Car c1 = new Car();
    c1 = new Sedan();
    c1 = new Truck();
    c1 = new SUV();
    c1 = new Convertible();
    c1 = new DumpTruck();
    c1 = new PickupTruck();
    
    Sedan c2 = new Sedan();
    c2 = new Sedan();
    c2 = new Convertible();
    c2 = new SUV();
//    c2 = new Car();
//    c2 = new Truck();
//    c2 = new DumpTruck();
//    c2 = new PickupTruck();
    
    
  }
}
