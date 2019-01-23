package design_pattern.abstract_factory;

import java.util.Scanner;

public class Test01 {
  public static void main(String[] args) {
    
    Scanner keyboard = new Scanner(System.in);
    int type;
    do {
      System.out.print("종족을 선택하시오?(1: 테란, 2:프로토스, 3:저그) ");
      type = keyboard.nextInt();
      if (type > 0 && type < 4) {
        break;
      }
      System.out.println("번호가 맞지 않습니다.");
    } while (true);
    keyboard.close();
    
    UnitFactory unitFactory = null;
    
    switch (type) {
      case 1:
        System.out.println("테란족을 선택하셨습니다.");
        unitFactory = new TerranUnitFactory();
        break;
      case 2:
        System.out.println("프로토스족을 선택하셨습니다.");
        unitFactory = new ProtossUnitFactory();
        break;
      default:
        System.out.println("저그족을 선택하셨습니다.");
        unitFactory = new ZergUnitFactory();
    }
    
    Unit u1 = unitFactory.createUnit(unitFactory.RESTAURANT);
    System.out.println("----------------------------------");
    Unit u2 = unitFactory.createUnit(unitFactory.TRAINING_CENTER);
  }
}
