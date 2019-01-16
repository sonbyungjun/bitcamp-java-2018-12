package ch11;

public class Test01 {
  public static void main(String[] args) {
    String s1;
    
    s1 = new String("Hello");
    
    String s2 = new String("Hello");
    
    if (s1 == s2) {
      System.out.println("같다!");
    } else {
      System.out.println("다르다!");
    }
  }
}
