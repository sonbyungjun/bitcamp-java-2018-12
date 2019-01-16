package ch10;

class My2 {
  int a = 100;

  {
    System.out.println("인스턴스 블록 실행! => a=" + this.a);
  }
  
  {
    System.out.println("여러 개의 인스턴스 블록을 가질 수 있다.");
  }
  
  My2() {
    System.out.println("생성자 호출! a=" + this.a);
  }
  
  void m1() {
    System.out.println("인스턴스 메서드: m1()");
  }
  
}

public class Test02 {
  public static void main(String[] args) {
    new My2();
  }
}
