package ch28.e;

import java.lang.annotation.Annotation;

@MyAnnotation7(
  name="홍길동",
      age=20)
public class Test04 {
  public static void main(String[] args) {
    
    Class<?> clazz = Test04.class;
    MyAnnotation7 anno1 = clazz.getAnnotation(MyAnnotation7.class);
    for (String s : anno1.value()) {
      System.out.println("==> " + s);
    }
    System.out.println(anno1.name());
    System.out.println(anno1.age());
    System.out.println(anno1.working());
    System.out.println("-------------------------------------");
    
    MyAnnotation7 anno2 = Test04.class.getAnnotation(MyAnnotation7.class);
    for (String s : anno2.value()) {
      System.out.println("==> " + s);
    }
    System.out.println(anno2.name());
    System.out.println(anno2.age());
    System.out.println(anno2.working());
    System.out.println("-------------------------------------");
    
    Annotation[] annotations = Test04.class.getAnnotations();
    MyAnnotation7 anno3 = (MyAnnotation7) annotations[0];
    for (String s : anno3.value()) {
      System.out.println("==> " + s);
    }
    System.out.println(anno3.name());
    System.out.println(anno3.age());
    System.out.println(anno3.working());
    
  }
}
