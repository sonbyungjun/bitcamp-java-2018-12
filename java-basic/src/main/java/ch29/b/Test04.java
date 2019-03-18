package ch29.b;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test04 {
  public static void main(String[] args) {
    ApplicationContext iocContainer = 
        new ClassPathXmlApplicationContext("ch29/b/application-context-04.xml");
    
    String[] names = iocContainer.getBeanDefinitionNames();
    for (String name : names) {
      System.out.printf("%s ==> %s\n", name, iocContainer.getBean(name).getClass().getName());
      
      System.out.printf("  %s 객체의 별명: ", name);
      String[] aliases = iocContainer.getAliases(name);
      for (String alias : aliases) {
        System.out.print(alias + "      ");
      }
      System.out.println();
    }
    
  }
}
