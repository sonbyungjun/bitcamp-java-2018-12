package ch29.c;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test01 {
  public static void main(String[] args) {
    ApplicationContext iocContainer = 
        new ClassPathXmlApplicationContext("ch29/c/application-context-01.xml");
    
    System.out.println("------------------------------------------");
    
    
    
  }
}
