package design_pattern.observer.after2;

public class Test01 {
  
  public static void main(String[] args) {
    Car car = new Car();
    
    car.addObserver(new SafeBeltCarObserver());
    car.addObserver(new EngineOilCarObserver());
    car.addObserver(new BreakOilCarObserver());
    car.addObserver(new LightOffCarObserver());
    car.addObserver(new SunRoofCloseCarObserver());
    
    car.start();
    car.run();
    car.stop();
    
  }
  
}
