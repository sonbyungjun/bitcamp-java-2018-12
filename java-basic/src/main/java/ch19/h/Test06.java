package ch19.h;

public class Test06 {

  static interface Player {
    void play();
  }
  
  static interface Player2 {
    
    static String info() {
      return "player2입니다.";
    }
    
    void stop();
  }
  
  static interface Player3 {
    void play();
    void stop();
  }
  
  static abstract class Player4 {
    public abstract void play();
  }
  
  public static void main(String[] args) {

    Player p1 = () -> System.out.println("player...");
    p1.play();
    
    Player2 p2 = () -> System.out.println("player2...");
    p2.stop();
    System.out.println(Player2.info());
    
//    Player3 p3 = () -> System.out.println("player3...");
    
    //Player4 p4 = () -> System.out.println("player4...");
  }
}
