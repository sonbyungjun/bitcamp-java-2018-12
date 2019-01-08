package ch05;

public class Test05 {
  public static void main(String[] args) {
    String str = "yes";
    
    switch (str) {
      case "ok":
        System.out.println("okokokok");
        break;
      case "no":
        System.out.println("nononono");
        break;
      default:
        System.out.println("??????");
    }
    
  }
}