package design_pattern.Decorator.before;

public class Convertible extends Sedan {
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
  
  
}
