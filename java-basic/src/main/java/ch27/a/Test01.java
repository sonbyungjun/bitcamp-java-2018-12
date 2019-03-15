package ch27.a;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class Test01 {
  
  public static void main(String[] args) {
    
    class MyHandler implements InvocationHandler {

      @Override
      public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        int a = (int) args[0];
        int b = (int) args[1];
        switch (method.getName()) {
          case "plus":
            return a + b;
          case "minus":
            return a - b;
        }
        return 0;
      }
      
    }
    
    Calculator c1 = (Calculator) Proxy.newProxyInstance(
        Calculator.class.getClassLoader(), 
        new Class[] {Calculator.class}, 
        new MyHandler());
    
    System.out.println(c1.plus(10, 20));
    
    System.out.println(c1.minus(10, 20));
    
  }
  
}
