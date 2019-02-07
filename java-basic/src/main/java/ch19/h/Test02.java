package ch19.h;

public class Test02 {

  static interface player {
    void play();
  }

  public static void main(String[] args) {

    player p2 = () -> System.out.println("테스트1");

    player p3 = () -> {System.out.println("테스트1");};
    
  }
}
