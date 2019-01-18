package ch13.i;

public class Convertible extends Car {
  boolean open;
  
  public void openRoof() {
    open = true;
  }
  
  public void closeRoof() {
    open = false;
  }
}
