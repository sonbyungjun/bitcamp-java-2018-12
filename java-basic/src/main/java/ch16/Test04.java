package ch16;

import java.io.File;
import java.util.Calendar;
import java.util.Date;

class Box1 {
  Object value;
  
  public Box1(Object value) {
    this.value = value;
  }
  
  public Object getValue() {
    return this.value;
  }
}

class Box2<T> {
  T value;
  
  public Box2(T value) {
    this.value = value;
  }
  
  public T getValue() {
    return this.value;
  }
}

public class Test04 {
  public static void main(String[] args) {
    
    Box1 b1 = new Box1(100);
    Box1 b2 = new Box1("Hello");
    Box1 b3 = new Box1(new Date());
    
    int v1 = (int) b1.getValue();
    String v2 = (String) b2.getValue();
    Date v3 = (Date) b3.getValue();
    
    Box2<String> x1 = new Box2<String>("홍길동");
    
    Box2<String> x2 = new Box2<>("임꺽정");
    
    Box2<String> x3;
    x3 = new Box2<>("유관순");
    
//    Box2<String> x4 = new Box2<>(new Date());
    
    String y1 = x1.getValue();
    String y2 = x2.getValue();
    String y3 = x3.getValue();
    
    Box2<Date> x4 = new Box2<>(new Date());
    Date y4 = x4.getValue();
    
  }
  
  public static <Ok> Ok echo(Ok obj) {
    return obj;
  }
  
}
