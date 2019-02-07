package design_pattern.Decorator.before;

public class HybridTruck extends Hybrid {

  public void dump() {
    this.stop();
    System.out.println("짐을 내린다.");
    this.run();
  }

}
