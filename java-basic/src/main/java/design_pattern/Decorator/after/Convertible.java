package design_pattern.Decorator.after;

public class Convertible extends Decorator {

  boolean openRoof;
  
  public Convertible(Car car) {
    super(car);
  }

  @Override
  public void run() {
    this.car.run();
    if (openRoof) {
      System.out.println("지붕을 연다!");
    } else {
      System.out.println("지붕을 닫는다!");
    }
  }
  
  public void openRoof(boolean openRoof) {
    this.openRoof = openRoof;
  }
  
}
