package design_pattern.Decorator.before;

public class Sedan extends Car {

  @Override
  public void run() {
     System.out.println("달린다!");
  }
  
  public void openSunRoof() {
    System.out.println("썬루프를 연다.");
  }

  public void closeSunRoof() {
    System.out.println("썬루프를 닫는다.");
  }
}
