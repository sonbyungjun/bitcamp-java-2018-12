package design_pattern.Decorator.after;

public class Test01 {
  public static void main(String[] args) {
    Truck c1 = new Truck();
    Hybrid c2 = new Hybrid(c1);
    c2.run();
    System.out.println("--------------------------------");
    Convertible c3 = new Convertible(c2);
    c3.openRoof(true);
    c3.run();
    
    Sedan s1 = new Sedan();
    Convertible c4 = new Convertible(s1);
    c4.openRoof(true);
    System.out.println("--------------------------------");
    c4.run();
    System.out.println("--------------------------------");
    Dump c5 = new Dump(c4);
    c5.run();
    System.out.println("--------------------------------");
    Dump c6 = new Dump(c3);
    c6.run();
  }
}
