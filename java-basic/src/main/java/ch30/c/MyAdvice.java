package ch30.c;

public class MyAdvice {
  
  public void advice1() {
    System.out.printf("%s.advice1()\n", this.getClass().getName());
  }
  
  public void advice2() {
    System.out.printf("%s.advice2()\n", this.getClass().getName());
  }

}
