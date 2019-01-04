package ch03;

public class Test01 {
  public static void main(String[] args) {
    byte b1;
    byte b2;
    byte b3;
    
    b1 = -128;
    b2 = 127;
//    b3 = 128;
    
    short s1;
    short s2;
    short s3;
    
    s1 = -32768;
    s2 = 32767;
//    s3 = 32768;
    
    int i1;
    int i2;
    int i3;
    
    i1 = -2100000000;
    i2 = 2100000000;
//    i3 = 2200000000;
    
    long l1;
    long l2;
    long l3;
    
    l1 = 9223000000000000000L;
//    l2 = 9923000000000000000L;
    
    
    float f1;
    float f2;
    
    f1 = 9876.543f;
    f2 = 12.34567f;
    System.out.println(f1);
    System.out.println(f2);
    
    
    float f3;
    f3 = f1 + f2;
    
    double d3;
    d3 = f1 + f2;
    
    System.out.println(f1);
    System.out.println(f2);
    System.out.println("합:" + f3);
    System.out.println("double 합:" + d3);
    
    double d1;
    double d2;

    
    d1 = 98765.43;
    d2 = 98765.4345666789;
    System.out.println(d1);
    System.out.println(d2);
    
    boolean bool1;
    boolean bool2;
    boolean bool3;
    
    bool1 = true;
    bool2 = false;
//    bool3 = 1;
    
    char c1;
    char c2;
    char c3;

    c1 = 44032;
    c2 = 0xac00;
    c3 = '가';
    
    System.out.println(c1);
    System.out.println(c2);
    System.out.println(c3);
    
    
  }
}
