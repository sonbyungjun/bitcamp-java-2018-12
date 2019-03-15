package ch27.a;

import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class Test03 {

  public static void main(String[] args) {

    Object proxy = Proxy.newProxyInstance(
        Test03.class.getClassLoader(), 
        new Class[] {Calculator.class, Calculator2.class, Calculator3.class}, 
        (Object proxyobj, Method method, Object[] params) -> {
            int a = (int) params[0];
            int b = (int) params[1];
            switch (method.getName()) {
              case "plus":
                return a + b;
              case "minus":
                return a - b;
              case "multiple":
                return a * b;
              case "divide":
                return a / b;
              case "mod":
                return a % b;
            }
            return 0;
          });

    Calculator c1 = (Calculator) proxy;
    Calculator2 c2 = (Calculator2) proxy;
    Calculator3 c3 = (Calculator3) proxy;

    System.out.println(c1.plus(10, 20));
    System.out.println(c1.minus(10, 20));
    System.out.println(c2.multiple(10, 20));
    System.out.println(c2.divide(10, 20));
    System.out.println(c3.mod(10, 20));

  }

}
