package design_pattern.Decorator.after;

public class Dump extends Decorator {

  public Dump(Car car) {
    super(car);
  }

  @Override
  public void run() {
    this.car.stop();
    this.dump();
    this.car.run();
  }
  
  public void dump() {
    System.out.println("짐을 내린다.");
  }

}
