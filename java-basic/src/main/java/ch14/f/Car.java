package ch14.f;

public abstract class Car {
  String model;
  int cc;
  
  public abstract void run();
  
  public void stop() {
    System.out.println("멈춘다!");
  }
  
}
