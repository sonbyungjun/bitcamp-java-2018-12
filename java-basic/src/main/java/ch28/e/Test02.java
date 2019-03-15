package ch28.e;

//@MyAnnotation
public class Test02 {
  
  @MyAnnotation4(
      value="okok",
      name="홍길동",
      age=20,
      working=true)
  int a;
  
  /*
  @MyAnnotation4(
      "okok",
      name="홍길동",
      age=20,
      working=true)
      */
  int b;
  
  @MyAnnotation5("okok")
  int c;
  
}
