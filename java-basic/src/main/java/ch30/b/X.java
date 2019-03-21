package ch30.b;

import org.springframework.stereotype.Component;

@Component
public class X {
  public void m1() {
    MyAdvice myadvice = new MyAdvice();
    myadvice.advice1();
    System.out.println("X.m1()");
  }
}
