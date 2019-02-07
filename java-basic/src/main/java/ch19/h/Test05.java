package ch19.h;

public class Test05 {

  static interface Calculrator {
    int compute(int a ,int b);
  }

  public static void main(String[] args) {

    Calculrator c1 = (a, b) -> { return a + b; };
    System.out.println(c1.compute(10, 20));
    
    Calculrator c2 = (a, b) -> a - b;
    System.out.println(c2.compute(10, 20));
    
    Calculrator c3 = (a, b) -> Math.max(a, b);
    System.out.println(c3.compute(10, 20));

    //Calculrator c4 = (a, b) -> System.out.println(a + "," + b);
    //System.out.println(c3.compute(10, 20));

  }
}
