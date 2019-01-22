package ch18.c;

public class Tool2 implements ProtocolA, ProtocolC {
  @Override
  public void m1() {
   System.out.println("Tool.m1()"); 
  }
  
  @Override
  public void m2() {
   System.out.println("Tool.m2()"); 
  }
  
  @Override
  public int m2() {
   System.out.println("Tool.m2()"); 
   return 0;
  }
  
  @Override
  public void m3() {
   System.out.println("Tool.m3()"); 
  }
}
