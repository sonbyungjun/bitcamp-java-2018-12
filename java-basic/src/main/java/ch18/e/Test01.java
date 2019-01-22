package ch18.e;

public class Test01 {
  public static void main(String[] args) {
    BallPen153 t1 = new BallPen153();
    MultiPen t2 = new MultiPen();
    
    Canvas c1 = new Canvas(t1);
    
    t1.press(true);
    c1.render("오호라.... 펜으로 그린 것!");
    
    c1.setPen(t2);
    t2.rotate(t2.ON);
    c1.render("오호라.... 펜으로 그린 것!");
  }
}
