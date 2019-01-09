package ch06;

public class Test02 {
  public static void main(String[] args) {
    //    m1();
    //    m1(20, "홍길동");
    //    m1(20, 30);
    //    m1("홍길동", 20, 30);
    m1("홍길동", 20);
    m1("임꺽정",
        30);
    m1(
        "유관순",
        17
     );

  }

  static void m1(String name, int age) {
    System.out.printf("이름: %s\n", name);
    System.out.printf("나이: %d\n", age);
  }

}
