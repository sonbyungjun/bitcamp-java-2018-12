package bitcamp;

import java.util.Set;
import javax.servlet.ServletContainerInitializer;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.HandlesTypes;

@HandlesTypes(ApplicationInitializer.class)
public class ServletContainerInitializerImpl3 implements ServletContainerInitializer {
  
  @Override
  public void onStartup(Set<Class<?>> types, ServletContext ctx) throws ServletException {
    
    System.out.println("ServletContainerInitializerImpl3.onStartup()....호출됨");
    
    System.out.println("ApplicationIntializer 구현체 목록 :");
    for (Class<?> type : types) {
      System.out.println("===> " + type.getName());
      try {
      ApplicationInitializer obj = (ApplicationInitializer) type.getConstructor().newInstance();
      obj.begin();
      } catch (Exception e) {
      }
    }
  }
}
