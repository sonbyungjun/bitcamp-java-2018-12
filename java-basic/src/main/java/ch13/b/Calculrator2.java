package ch13.b;

import ch13.Calculrator;

public class Calculrator2 extends Calculrator {
  
  public void multiple(int value) {
    this.result *= value;
  }
  
  public void divide(int value) {
    this.result /= value;
  }
}
