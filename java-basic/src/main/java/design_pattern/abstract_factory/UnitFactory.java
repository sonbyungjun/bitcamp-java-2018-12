package design_pattern.abstract_factory;

public interface UnitFactory {
  
  int RESTAURANT = 1;
  int TRAINING_CENTER = 2;
  
  Unit createUnit(int buliding);
}
