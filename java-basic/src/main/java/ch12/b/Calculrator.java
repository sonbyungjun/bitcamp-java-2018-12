package ch12.b;

public class Calculrator {
  private int result;
  
  public int getResult() { 
    return this.result;
  }
  
  public void plus(int value) {
    this.result += value;
  }
  
  public void minus(int value) {
    this.result -= value;
  }
}
