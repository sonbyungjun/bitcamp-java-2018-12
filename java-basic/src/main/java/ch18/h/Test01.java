package ch18.h;

public class Test01 {
  public static void main(String[] args) {
    Pen pen = new MyPen();
    Pen pen2 = new BallPen153();
    
    pen.on();
    pen.write("1");
    
    pen2.on();
    pen2.write("1");
    
    
  }
}
