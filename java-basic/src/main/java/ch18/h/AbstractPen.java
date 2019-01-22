package ch18.h;

public abstract class AbstractPen implements Pen {
  
  boolean use;
  
  @Override
  public void on() {
    this.use = true;
  }
  
  @Override
  public void off() {
    this.use = false;
  }
  
}
