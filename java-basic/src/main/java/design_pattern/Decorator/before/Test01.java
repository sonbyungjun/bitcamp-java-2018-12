package design_pattern.Decorator.before;

public class Test01 {
  public static void main(String[] args) {
    HybridTruck c1 = new HybridTruck();
    c1.dump();
    
    HybridConvertible c2 = new HybridConvertible();
    c2.open(true);
    c2.run2();
  }
}
