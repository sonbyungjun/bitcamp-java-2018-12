package ch09;

public class Test05 {
  public static void main(String[] args) {
    
    Calculrator3 c1 = new Calculrator3();
    Calculrator3 c2 = new Calculrator3();
    
    Calculrator3.plus(c1, 2);
    Calculrator3.plus(c2, 6);
    
    Calculrator3.multiple(c1, 3);
    Calculrator3.divide(c2, 2);
    
    Calculrator3.minus(c1, 2);
    Calculrator3.plus(c2, 9);
    
    Calculrator3.plus(c1, 7);
    
    System.out.println(c1.result);
    System.out.println(c2.result);
  }
}
