package ch13.a;

public class Test01 {
  public static void main(String[] args) {
    Calculrator2 c1 = new Calculrator2();
    c1.plus(5);
    c1.multiple(2);
    c1.minus(2);
    c1.divide(4);
    System.out.println(c1.getResult());
  }
}
