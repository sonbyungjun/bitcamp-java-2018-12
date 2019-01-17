package ch14.c;

public class Calculrator {
  int result;
  
  public void plus(int value) {
    this.result += value;
  }
  
  public void plus(int v1, int v2) {
    this.result += v1 + v2;
  }
  
  public void minus(int value) {
    this.result -= value;
  }
  
  public void plus(int[] arr) {
    for (int value : arr) {
      result += value;
    }
  }
}
