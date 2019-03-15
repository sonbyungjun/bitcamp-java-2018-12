package ch28.a;

@MyAnnotation
//@MyAnnotation 
public class Test01 {
  
  @MyAnnotation
  static int a;
  
  @MyAnnotation
  int b;
  
  @MyAnnotation
  void m1(
      @MyAnnotation int p1, 
      @MyAnnotation String p2) {
    
    @MyAnnotation int local;
    
//    @MyAnnotation System.out.println("okok");
    
    for (int i = 0; i < 100; i++) {
      @MyAnnotation int a;
    }
  }
  
  @MyAnnotation
  static void m2() {
    
  }
  
}
