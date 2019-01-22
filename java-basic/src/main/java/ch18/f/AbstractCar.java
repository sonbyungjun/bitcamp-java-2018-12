package ch18.f;

public abstract class AbstractCar {
  
  String model;
  int cc;
  
  public void on() {
    System.out.println("시동을 켠다.");
  }
  
  public void off() {
    System.out.println("시동을 끈다.");
  }
  
  public abstract void run();
}
