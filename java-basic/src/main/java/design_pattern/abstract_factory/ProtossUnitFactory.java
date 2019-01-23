package design_pattern.abstract_factory;

public class ProtossUnitFactory implements UnitFactory {
  
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
    unit.setName("프로토스: 군인식당");
    unit.setArea(70);
    unit.setType(unit.DEFENCE_BUILDING);
    unit.build();
    return unit;
  }
  
  private Unit createTrainingCenter() {
    Unit unit = new TrainingCenter();
    unit.setName("프로토스: 훈련소");
    unit.setArea(300);
    unit.setType(unit.ATTACK_BUILDING);
    unit.build();
    return unit;
  }
}
