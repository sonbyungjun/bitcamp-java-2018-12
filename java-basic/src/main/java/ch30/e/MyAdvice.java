package ch30.e;

public class MyAdvice {
  
  public void doBefore(String p1, int p2, int p3) {
    System.out.printf("%s.doBefore()\n", this.getClass().getName());
    System.out.printf("  => %s %d %d\n", p1, p2, p3);
  }
  
  public void doAfter() {
    System.out.printf("%s.doAfter()\n", this.getClass().getName());
  }

  public void doAfterReturning(Object rv) {
    System.out.printf("%s.doAfterReturning()\n", this.getClass().getName());
    System.out.printf("  -> %d\n", rv);
  }

  public void doAfterThrowing(Exception err) {
    System.out.printf("%s.doAfterThrowing()\n", this.getClass().getName());
    System.out.printf("  => %s\n", err.getMessage());
  }

}
