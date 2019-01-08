package ch04;

public class Test16 {
  public static void main(String[] args) {
    int a = 0xc9;
    System.out.println(a);
    System.out.println(Integer.toHexString(a << 1));
    System.out.println(a << 1);
    System.out.println();
    
    System.out.println(Integer.toHexString(a << 2));
    System.out.println(a << 2);
    System.out.println();
    
    System.out.println(Integer.toHexString(a << 3));
    System.out.println(a << 3);
    System.out.println();
    
    System.out.println(Integer.toHexString(a << 4));
    System.out.println(a << 4);
    System.out.println();
    
    a = -0x7f_ff_ff_fa;
    System.out.println(a);
    System.out.println(a << 1);
    System.out.println(a << 2);
    System.out.println(a << 3);
    System.out.println(a << 4);
  }
}
