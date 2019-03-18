package ch29.a;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test02_j {
  public static void main(String[] args) {
    ApplicationContext iocContainer = 
        new AnnotationConfigApplicationContext(AppConfig02.class);
    
    Student b1 = (Student) iocContainer.getBean("b1");
    System.out.println(b1);
    
    Student b2 = (Student) iocContainer.getBean("b2");
    System.out.println(b2);
    
    System.out.println("실행 완료!");
  }
}
