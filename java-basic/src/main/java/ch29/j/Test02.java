package ch29.j;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test02 {
  public static void main(String[] args) {
    ApplicationContext iocContainer = 
        new AnnotationConfigApplicationContext("ch29.j");
    
    System.out.println("------------------------------------------");
    
    String[] names = iocContainer.getBeanDefinitionNames();
    for (String name : names) {
      System.out.printf("%s ==> %s\n" , name, iocContainer.getBean(name).getClass().getName());
    }
    
    System.out.println("------------------------------------------");
    
  }
}
