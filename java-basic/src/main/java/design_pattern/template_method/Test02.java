package design_pattern.template_method;

public class Test02 {
  public static void main(String[] args) {
    UnitFactory unitFactory = new UnitFactory();
    Unit u1 = unitFactory.createUnit(unitFactory.RESTAURANT);
    System.out.println("----------------------------------");
    Unit u2 = unitFactory.createUnit(unitFactory.TRAINING_CENTER);
  }
}
