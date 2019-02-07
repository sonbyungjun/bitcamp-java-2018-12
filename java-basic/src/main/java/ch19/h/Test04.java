package ch19.h;

public class Test04 {

  static interface player {
    void play(String name ,int age);
  }

  public static void main(String[] args) {

    player p1 = (String name,int age) -> 
    System.out.printf("%s(%d)님 환영합니다.\n", name, age);
    p1.play("홍길동", 20);

    player p2 = (name, age) -> 
    System.out.printf("%s(%d)님 환영합니다.\n", name, age);
    p2.play("임꺽정", 30);
    
    //player p3 = name, age -> 
    //System.out.printf("%s(%d)님 환영합니다.\n", name, age);
    //p3.play("임꺽정", 30);
  }
}
