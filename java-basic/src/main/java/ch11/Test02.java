package ch11;

public class Test02 {
  public static void main(String[] args) {
    String s1;
    s1 = "Hello";
    
    String s2 = "Hello";
    
    if (s1 == s2) {
      System.out.println("s1 == s2");
    } else {
      System.out.println("s1 != s2");
    }
    
    String s3 = new String("Hello");
    
    if (s1 == s3) {
      System.out.println("s1 == s3");
    } else {
      System.out.println("s1 != s3");
    }
    
    System.out.println(s1 instanceof String);
    System.out.println(s2 instanceof String);
    System.out.println(s3 instanceof String);
  }
  
}
