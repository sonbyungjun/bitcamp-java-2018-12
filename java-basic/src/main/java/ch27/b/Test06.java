package ch27.b;

import static java.lang.reflect.Modifier.FINAL;
import static java.lang.reflect.Modifier.PRIVATE;
import static java.lang.reflect.Modifier.PROTECTED;
import static java.lang.reflect.Modifier.PUBLIC;
import static java.lang.reflect.Modifier.STATIC;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

public class Test06 {
  
  public static void main(String[] args) throws Exception {
    
    Class<?> clazz = C.class;
    
    Method[] methods = clazz.getMethods();
    for (Method m : methods) {
      System.out.printf("클래스명: %s\n", m.getDeclaringClass().getSimpleName(), m.getName());
      System.out.printf("파라미터: %d\n", m.getParameterCount());
    }
    

  }
  
}
