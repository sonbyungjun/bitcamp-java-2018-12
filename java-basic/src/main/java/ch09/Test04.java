package ch09;

public class Test04 {
  public static void main(String[] args) {
    
    int result1 = 0;
    int result2 = 0;
    
    result1 = Calculrator1.multiple(2, 3);
    result2 = Calculrator1.divide(6, 2);
    
    result1 = Calculrator1.minus(result1, 2);
    result2 = Calculrator1.plus(result2, 8);
    
    result1 = Calculrator1.plus(result1, 7);
    
    System.out.println(result1);
    System.out.println(result2);
    
  }
}
