package ch08.util;

public class Calculrator2 {
  
  public static int plus(int a, int b) {
    return a + b;
  }

  public static int minus(int a, int b) {
    return a - b;
  }

  public static int multiple(int a, int b) {
    return a * b;
  }

  public static int divide(int a, int b) {
    return a / b;
  }
  
  public static int abs(int a) {
    return (a >= 0) ? a : a * -1;
  }
  
}
