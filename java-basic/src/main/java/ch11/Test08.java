package ch11;

public class Test08 {
  public static void main(String[] args) {
    StringBuffer b1 = new StringBuffer("Hello");
    StringBuffer b2 = new StringBuffer("Hello");
    
    System.out.println(b1 == b2);
    System.out.println(b1.equals(b2));
    
    
  }
}
