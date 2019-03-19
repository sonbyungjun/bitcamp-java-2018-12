package ch29.h;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test08 {
  public static void main(String[] args) {
    ApplicationContext iocContainer = 
        new ClassPathXmlApplicationContext("ch29/h/application-context-08.xml");
    
    System.out.println("------------------------------------------");
    
    System.out.println(iocContainer.getBean("c1"));
    
    
  }
}
