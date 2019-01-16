package ch09;

public class Test06 {
  public static void main(String[] args) {
    
    Calculrator4 c1 = new Calculrator4();
    Calculrator4 c2 = new Calculrator4();
    
    c1.plus(2);
    c2.plus(6);
    
    c1.multiple(3);
    c2.divide(2);
    
    c1.minus(2);
    c2.plus(9);
    
    c1.plus(7);
    
    System.out.println(c1.result);
    System.out.println(c2.result);
    
    Calculrator4 c3 = null;
    c3.plus(3);
  }
}
