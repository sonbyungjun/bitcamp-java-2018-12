package ch27.b;

public class C extends B implements Calculator, Calculator2, Calculator3{
  
  private int c_private_var;
  int c_default_var;
  protected int c_protected_var;
  public int c_public_var;
  
  static {
    System.out.println("나C클래스야");
  }
  
  private void c_private() {}
  void c_default() {}
  protected void c_protected() {}
  public void c_public() {}
  
  public int mod(int a, int b) {return 0;}
  public int multiple(int a, int b) {return 0;}
  public int divide(int a, int b) {return 0;}
  public int plus(int a, int b) {return 0;}
  public int minus(int a, int b) {return 0;}
  
  
}
