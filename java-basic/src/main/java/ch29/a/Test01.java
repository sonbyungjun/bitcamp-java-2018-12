package ch29.a;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class Test01 {
  public static void main(String[] args) {
    ApplicationContext iocContainer1 = 
        new ClassPathXmlApplicationContext("ch29/a/application-context.xml");
    
    ApplicationContext iocContainer2 = 
        new FileSystemXmlApplicationContext(
            "file:///Users/byungjun/git/bitcamp-java-2018-12/java-basic/bin/main/ch29/a/application-context.xml");
    
    ApplicationContext iocContainer3 = 
        new AnnotationConfigApplicationContext(AppConfig.class);
    
    System.out.println("실행 완료!");
  }
}
