package ch05;

public class Test07 {
  public static void main(String[] args) {
    String type = "개발팀장";
    
    int score = 60;
    switch (score) {
      case 100:
      case 90:
        System.out.println("A");
        break;
      case 80:
      case 70:
        System.out.println("B");
        break;
      case 60:
      case 50:
      case 40:
        System.out.println("C");
        break;
      default:
        System.out.println("F");
    }
    
  }
}