package ch29.f;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test03 {
  public static void main(String[] args) {
    ApplicationContext iocContainer = 
        new ClassPathXmlApplicationContext("ch29/f/application-context-03.xml");
    
    System.out.println("------------------------------------------");
    
    System.out.println(iocContainer.getBean("blackBox"));
    System.out.println(iocContainer.getBean("carFactory"));
    System.out.println(iocContainer.getBean("c1"));
    System.out.println(iocContainer.getBean("c1"));
    
  }
}
