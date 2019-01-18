package ch13.h;

public class DumpTruck {
  String medol;
  int cc;
  int weight;
  
  public void run() {
    System.out.println("달린다");
  }
  
  public void stop() {
    System.out.println("멈춘다");
  }
  
  public void dump() {
    System.out.println("짐을 내린다.");
  }
}
