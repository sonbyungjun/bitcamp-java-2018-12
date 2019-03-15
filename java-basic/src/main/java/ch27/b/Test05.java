package ch27.b;

import static java.lang.reflect.Modifier.FINAL;
import static java.lang.reflect.Modifier.PRIVATE;
import static java.lang.reflect.Modifier.PROTECTED;
import static java.lang.reflect.Modifier.PUBLIC;
import static java.lang.reflect.Modifier.STATIC;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

public class Test05 {
  
  public static void main(String[] args) throws Exception {
    
    Class<?> clazz = String.class;
    
    Method[] methods = clazz.getDeclaredMethods();
    for (Method m : methods) {
      System.out.printf("메서드명: %s.%s\n", m.getDeclaringClass().getSimpleName(), m.getName());
      System.out.printf("파라미터: %d\n", m.getParameterCount());
      Parameter[] params = m.getParameters();
      for (Parameter p : params) {
        System.out.printf("    %s:%s\n", 
            p.getName(),
            p.getType().getName()
            );
      }
      System.out.println("리턴 타입:");
      System.out.printf("    %s\n", m.getReturnType().getName());
      
      System.out.println("modifier:");
      int modifiers = m.getModifiers();
      if ((modifiers & PUBLIC) != 0) 
        System.out.println("    public");
      else if ((modifiers & PROTECTED) != 0) 
        System.out.println("    protected");
      else if ((modifiers & PRIVATE) != 0) 
        System.out.println("    private");
      
      if ((modifiers & STATIC) != 0)
        System.out.println("    static");
      
      if ((modifiers & FINAL) != 0)
        System.out.println("    final");
      
      System.out.println("-------------------------------------");
    }
    

  }
  
}
