// 예외 던지기 - 예외를 보고하지 않는 경우
package ch21.f;

public class Test03 {

  static class MyResource1 {
    public int divide(int a, int b) {
      return a / b;
    }
    public void close() {
      System.out.println("MyResource1.close()");
    }
  }

  static class MyResource2 implements AutoCloseable {
    public int divide(int a, int b) {
      return a / b;
    }
    @Override
    public void close() {
      System.out.println("MyResource2.close()");
    }
  }

  public static void main(String[] args) {
    
    try (
        //MyResource1 r1 = new MyResource1();
        MyResource2 r2 = new MyResource2();
        ) {
      System.out.println(r2.divide(10, 2));
      System.out.println(r2.divide(10, 0));
    } catch (Exception e) {
      System.out.println("예외 발생!");
    }
    
  }
}






