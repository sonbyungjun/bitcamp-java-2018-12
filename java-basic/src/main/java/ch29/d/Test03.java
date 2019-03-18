package ch29.d;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test03 {
  public static void main(String[] args) {
    ApplicationContext iocContainer = 
        new ClassPathXmlApplicationContext("ch29/d/application-context-03.xml");
    
    System.out.println("------------------------------------------");
    
    Car c1 = (Car) iocContainer.getBean("c1");
    //Car c2 = (Car) iocContainer.getBean("c2");
    Car c3 = (Car) iocContainer.getBean("c3");
    
    System.out.println(c1);
    //System.out.println(c2);
    System.out.println(c3);
    
    System.out.println(c1.getBlackBox() == c3.getBlackBox());
    
  }
}
