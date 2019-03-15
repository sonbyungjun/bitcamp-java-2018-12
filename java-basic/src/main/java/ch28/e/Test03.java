package ch28.e;

//@MyAnnotation
public class Test03 {
  
  @MyAnnotation6(value={"aaa"})
  int a;
  
  @MyAnnotation6({"aaa"})
  int b;
  
  @MyAnnotation6("aaa")
  int c;
  
//  @MyAnnotation6("aaa", "bbb")
  int d;
  
  @MyAnnotation6({"aaa", "bbb"})
  int e;
}
