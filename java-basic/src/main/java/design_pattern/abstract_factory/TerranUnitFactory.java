package design_pattern.abstract_factory;

public class TerranUnitFactory implements UnitFactory {
  
  @Override
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
    unit.setName("테란: 군인식당");
    unit.setArea(50);
    unit.setType(unit.GENERAL_BUILDING);
    unit.build();
    return unit;
  }
  
  private Unit createTrainingCenter() {
    Unit unit = new TrainingCenter();
    unit.setName("테란: 훈련소");
    unit.setArea(500);
    unit.setType(unit.GENERAL_BUILDING);
    unit.build();
    return unit;
  }
}
