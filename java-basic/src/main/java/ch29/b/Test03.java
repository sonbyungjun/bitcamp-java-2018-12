package ch29.b;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test03 {
  public static void main(String[] args) {
    ApplicationContext iocContainer = 
        new ClassPathXmlApplicationContext("ch29/b/application-context-03.xml");
   
    System.out.println("----------------------------------------------");
    
    Car obj1 = (Car) iocContainer.getBean("c1");
    Car obj2 = (Car) iocContainer.getBean("c1");
    Car obj3 = (Car) iocContainer.getBean("c1");
    
    System.out.println(obj1 == obj2);
    System.out.println(obj1 == obj3);
    
    Car2 obj11 = (Car2) iocContainer.getBean("c2");
    Car2 obj12 = (Car2) iocContainer.getBean("c2");
    Car2 obj13 = (Car2) iocContainer.getBean("c2");
    
    System.out.println(obj11 == obj12);
    System.out.println(obj11 == obj13);

    Car3 obj21 = (Car3) iocContainer.getBean("c3");
    Car3 obj22 = (Car3) iocContainer.getBean("c3");
    Car3 obj23 = (Car3) iocContainer.getBean("c3");
    
    System.out.println(obj21 == obj22);
    System.out.println(obj21 == obj23);
    System.out.println(obj22 == obj23);
    
  }
}
