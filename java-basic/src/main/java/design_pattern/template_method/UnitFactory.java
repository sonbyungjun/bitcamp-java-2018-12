package design_pattern.template_method;

public class UnitFactory {
  
  public static final int RESTAURANT = 1;
  public static final int TRAINING_CENTER = 2;
  
  public Unit createUnit(int buliding) {
    switch (buliding) {
      case RESTAURANT:
        return createRestaurant();
      case TRAINING_CENTER:
        return createTrainingCenter();
    }
    return null;
  }
  
  private Unit createRestaurant() {
    Unit unit = new Restaurant();
    unit.setName("군인식당");
    unit.setArea(50);
    unit.setType(unit.GENERAL_BUILDING);
    unit.build();
    return unit;
  }
  
  private Unit createTrainingCenter() {
    Unit unit = new TrainingCenter();
    unit.setName("훈련소");
    unit.setArea(500);
    unit.setType(unit.GENERAL_BUILDING);
    unit.build();
    return unit;
  }
}
