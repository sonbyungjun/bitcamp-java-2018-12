package ch30.d;

public class MyAdvice {
  
  public void doBefore() {
    System.out.printf("%s.doBefore()\n", this.getClass().getName());
  }
  
  public void doAfter() {
    System.out.printf("%s.doAfter()\n", this.getClass().getName());
  }

  public void doAfterReturning() {
    System.out.printf("%s.doAfterReturning()\n", this.getClass().getName());
  }

  public void doAfterThrowing() {
    System.out.printf("%s.doAfterThrowing()\n", this.getClass().getName());
  }

}
