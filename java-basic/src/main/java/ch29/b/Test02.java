package ch29.b;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test02 {
  public static void main(String[] args) {
    ApplicationContext iocContainer = 
        new ClassPathXmlApplicationContext("ch29/b/application-context-02.xml");
    
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
    
    Car c6 = (Car) iocContainer.getBean("c6");
    Car c7 = (Car) iocContainer.getBean("c7");
    Car c8 = (Car) iocContainer.getBean("c8");
    Car c9 = (Car) iocContainer.getBean("c9");
    
    if (c6 == c7) System.out.println("c6 == c7");
    if (c6 == c8) System.out.println("c6 == c8");
    if (c6 == c9) System.out.println("c6 == c9");
  }
}
