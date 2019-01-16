package ch11;

public class Test05 {
  public static void main(String[] args) {
    String s1 = new String("Hello");
    String s2 = s1.replace('l', 'x');
    String s3 = s1.replace("ll", "dd");
    
    System.out.println(s1);
    System.out.println(s2);
    System.out.println(s3);
    System.out.println(s1 == s2);
    System.out.println(s2 == s3);
    System.out.println(s1 == s3);
    
  }
  
}
