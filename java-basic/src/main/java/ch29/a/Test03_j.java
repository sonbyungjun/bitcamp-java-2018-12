package ch29.a;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test03_j {
  public static void main(String[] args) {
    ApplicationContext iocContainer = 
        new AnnotationConfigApplicationContext(AppConfig03.class);
    
    Student2 obj1 = (Student2) iocContainer.getBean("student2");
    System.out.println(obj1);
    
    Student obj2 = (Student) iocContainer.getBean("sudent");
    System.out.println(obj2);
    
    System.out.println("실행 완료!");
  }
}
