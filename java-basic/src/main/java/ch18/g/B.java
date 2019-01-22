package ch18.g;

public interface B {
  void m1();
  //void m2();
  default void m2() {};
}
