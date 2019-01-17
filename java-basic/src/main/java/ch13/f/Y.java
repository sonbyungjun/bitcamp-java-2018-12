package ch13.f;

public class Y extends X {
  private int v2 = 200;
  
  public Y() {
    super(500);
    System.out.println("B.B()");
  }
  
  public void m2() {
    System.out.printf("B.v2 = %d\n", this.v2);
  }
}
