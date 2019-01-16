package ch10;

class A {
  static int a = 7;
  
  static {
    System.out.println("A.static{}");
    a += B.b;
  }
}

class B {
  static int b = 22;
  
  static {
    System.out.println("B.static{}");
    b += A.a;
  }
}

public class Test13 {
  public static void main(String[] args) {
    System.out.println(A.a);
    System.out.println(B.b);
  }
}
