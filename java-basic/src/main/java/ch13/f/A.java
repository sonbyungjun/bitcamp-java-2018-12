package ch13.f;

public class A {
  private int v1 = 100;
  
  public A() {
//    System.out.println("A.A()");
    super();
  }
  
  public void m1() {
    System.out.printf("A.v1 = %d\n", this.v1);
  }
}
