package ch04;

public class Test14 {
  public static void main(String[] args) {
    int a = 0xca;
    System.out.println(Integer.toHexString(a >> 4));
    System.out.println(a >> 4);
    System.out.println();
    
    System.out.println(Integer.toHexString(a >> 3));
    System.out.println(a >> 3);
    System.out.println();
    
    System.out.println(Integer.toHexString(a >> 2));
    System.out.println(a >> 2);
    System.out.println();
    
    System.out.println(Integer.toHexString(a >> 1));
    System.out.println(a >> 1);
    
    a = -202; 
    System.out.println(a >> 1);
    
    System.out.println(a >> 2);
    
    System.out.println(a >> 3);

    System.out.println(a >> 4);
    
  }
}
