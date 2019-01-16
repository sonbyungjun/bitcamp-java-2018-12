package ch09;

public class Calculrator3 {
  
  int result = 0;
  
  static void plus(Calculrator3 that, int a) {
//    result += a;
    that.result += a;
  }

  static void minus(Calculrator3 that, int a) {
//    result -= a;
    that.result -= a;
  }

  static void multiple(Calculrator3 that, int a) {
//    result *= a;
    that.result *= a;
  }

  static void divide(Calculrator3 that, int a) {
//    result /= a;
    that.result /= a;
  }
  
}
