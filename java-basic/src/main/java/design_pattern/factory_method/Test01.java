package design_pattern.factory_method;

class Car {
  String model;
  int cc;
  boolean sunroof;
  
  
  
}

public class Test01 {

  public static void main(String[] args) {
    Car c1 = new Car();
    c1.model = "티코";
    c1.cc = 890;
    c1.sunroof = false;
    
    Car c2 = new Car();
    c2.model = "티코 골드";
    c2.cc = 890;
    c2.sunroof = true;

    Car c3 = new Car();
    c3.model = "소나타";
    c3.cc = 1980;
    c3.sunroof = false;
    
    Car c4 = new Car();
    c3.model = "소나타 골드";
    c3.cc = 1980;
    c3.sunroof = true;
    
  }

}
