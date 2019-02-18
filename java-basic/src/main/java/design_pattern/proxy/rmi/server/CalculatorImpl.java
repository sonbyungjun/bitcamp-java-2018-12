package design_pattern.proxy.rmi.server;

public class CalculatorImpl implements Calculator {
  public int plus(int a, int b) {
    return a + b;
  }
  
  public int minus(int a, int b) {
    return a - b;
  }
}
