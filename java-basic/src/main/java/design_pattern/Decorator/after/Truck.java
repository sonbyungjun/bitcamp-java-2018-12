package design_pattern.Decorator.after;

public class Truck extends Car {
  int weight;
  
  @Override
  public void run() {
     System.out.println("덜컹덜컹 달린다!");
  }
  
  

}
