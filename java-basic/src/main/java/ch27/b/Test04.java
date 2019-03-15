package ch27.b;

import java.lang.reflect.Method;

public class Test04 {
  
  public static void main(String[] args) throws Exception {
    
    Class<?> clazz = C.class;
    
    Method m = clazz.getMethod("plus", int.class, int.class);
    System.out.println(m.getName());
    
    m = clazz.getMethod("c_public");
    System.out.println(m.getName());
  }
  
}
