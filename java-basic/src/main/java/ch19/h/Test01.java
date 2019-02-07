package ch19.h;

public class Test01 {

  static interface player {
    void play();
  }

  public static void main(String[] args) {

    player p1 = new player() {
      public void play() {
        System.out.println("테스트1");
      }
    };

    p1.play();

    player p2 = () -> {
      System.out.println("테스트1");
    };

    p2.play();

  }
}
