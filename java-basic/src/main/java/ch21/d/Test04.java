// 예외 던지기 - throw 명령을 사용하여 예외를 보고하기
package ch21.d;

public class Test04 {
  
  public static void main(String[] args) throws Exception {
    m3();
    System.out.println("종료!");
  }
  
  static void m3() throws Exception {
    m2();
  }
  
  static void m2() throws Exception {
    m1();
  }
  
  static void m1() throws Exception {
    throw new Exception("m1()에서 발생한 예외");
  }
  
}






