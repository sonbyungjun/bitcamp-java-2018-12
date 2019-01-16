package ch11;

public class Test07 {
  public static void main(String[] args) {
    StringBuffer b1 = new StringBuffer("Hello");
    
    StringBuffer b2 = b1.replace(2, 4, "xxxxx");
    
    System.out.println(b1 == b2);
    
    System.out.println(b1.toString());
    System.out.println(b1);
  }
}
