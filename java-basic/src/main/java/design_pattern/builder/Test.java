package design_pattern.builder;

public class Test {

  public static void main(String[] args) {
    
    CarBuilder carBuilder = new CarBuilder();
    Car c1 = carBuilder.build("비트자동차 모델1");
    System.out.println(c1);
    System.out.println("-----------------------------------------------");
    Car c2 = carBuilder.build("비트자동차 모델2");
    System.out.println(c2);
    System.out.println("-----------------------------------------------");
    Car c3 = carBuilder.build("비트자동차 모델3");
    System.out.println(c3);
  }
  
}
