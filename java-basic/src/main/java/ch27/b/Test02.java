package ch27.b;

import java.lang.reflect.Method;

public class Test02 {
  
  public static void main(String[] args) throws Exception {
    
    Class<?> clazz = Calculator.class;
    
    Method[] methods = clazz.getMethods();
    
    for (Method m : methods) {
      System.out.println(m.getName());
    }
    
  }
  
}
