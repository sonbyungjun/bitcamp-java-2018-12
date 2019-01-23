package design_pattern.abstract_factory;

public class ZergUnitFactory implements UnitFactory {
  
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
    unit.setName("저그: 군인식당");
    unit.setArea(200);
    unit.setType(unit.ATTACK_BUILDING);
    unit.build();
    return unit;
  }
  
  private Unit createTrainingCenter() {
    Unit unit = new TrainingCenter();
    unit.setName("저그: 훈련소");
    unit.setArea(100);
    unit.setType(unit.ATTACK_BUILDING);
    unit.build();
    return unit;
  }
}
