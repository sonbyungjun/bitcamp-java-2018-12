package ch11;

public class Test04 {
  public static void main(String[] args) {
    String s1 = new String("Hello");
    String s2 = new String("Hello");
    
    if (s1 == s2) {
      System.out.println("s1 == s2");
    } else {
      System.out.println("s1 != s2");
    }
    
    if (s1.equals(s2)) {
      System.out.println("s1과 s2의 문자열이 같다");
    } else {
      System.out.println("s1과 s2의 문자열이 다르다");
    }
    
    String s3 = "Hello";
    String s4 = "HELLO";
    
    if (s3.equals(s4)) {
      System.out.println("s3.equals(s4)");
    } 
    
    if (s3.equalsIgnoreCase(s4))
      System.out.println("s3.equalsIgnoreCase(s4)");
    
  }
  
}
