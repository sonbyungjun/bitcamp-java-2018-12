package ch27.b;

import java.lang.reflect.Method;

public class Test03 {
  
  public static void main(String[] args) throws Exception {
    
    Class<?> clazz = C.class;
    C c = new C();
    
    Method[] methods = clazz.getMethods();
    
    for (Method m : methods) {
      System.out.println(m.getName());
    }
    System.out.println("-----------------------");
    
    methods = clazz.getDeclaredMethods();
    
    for (Method m : methods) {
      System.out.println(m.getName());
    }
    
  }
  
}
