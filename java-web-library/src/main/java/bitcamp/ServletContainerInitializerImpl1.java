package bitcamp;

import java.util.Set;
import javax.servlet.ServletContainerInitializer;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;

public class ServletContainerInitializerImpl1 implements ServletContainerInitializer {
  
  @Override
  public void onStartup(Set<Class<?>> c, ServletContext ctx) throws ServletException {
    
    System.out.println("ServletContainerInitializerImpl1.onStartup()....호출됨");
    
  }
}
