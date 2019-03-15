package ch28.c;

@MyAnnotation
//@MyAnnotation2
//@MyAnnotation3
//@MyAnnotation4
public class Test01 {
  
  //@MyAnnotation
  @MyAnnotation2
//  @MyAnnotation3
  //@MyAnnotation4
  int i;
  
  //@MyAnnotation
  @MyAnnotation2
  //@MyAnnotation3
  //@MyAnnotation4
  static int j;
  
  //@MyAnnotation
  //@MyAnnotation2
  @MyAnnotation3
  //@MyAnnotation4
  public static void main(String[] args) {
    
//    @MyAnnotation
    //@MyAnnotation2
    //@MyAnnotation3
    @MyAnnotation4
    int local;
  }
  
}
