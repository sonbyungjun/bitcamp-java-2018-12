package design_pattern.Decorator.before;

public class HybridConvertible extends Hybrid {
  boolean openRoof;

  public void open(boolean open) {
    this.openRoof = open;
  }

  public void run2() {
    if (openRoof) {
      System.out.println("뚜껑연다.");
    } else {
      System.out.println("뚜껑닫는다.");
    }
    this.run();
  }
  @Override
  public void run() {
    if(this.speed <= 60) {
      System.out.println("모터로 달린다.");
    } else {
      System.out.println("달린다!");
    }
  }

}
