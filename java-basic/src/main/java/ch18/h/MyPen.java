package ch18.h;

public class MyPen implements Pen{

  boolean use;

  @Override
  public void on() {
    this.use = true;
  }

  @Override
  public void off() {
    this.use = false;
  }

  @Override
  public void write(String text) {
    if (!this.use)
      return;
    System.out.println("===> " + text);
  }
}
