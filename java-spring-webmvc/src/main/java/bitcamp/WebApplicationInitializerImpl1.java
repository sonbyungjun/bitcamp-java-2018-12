package bitcamp;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration.Dynamic;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class WebApplicationInitializerImpl1 implements WebApplicationInitializer {
  
  @Override
  public void onStartup(ServletContext servletContext) throws ServletException {
    System.out.println("WebApplicationInitializerImpl1.onStartup()...호출됨!");
    
    AnnotationConfigWebApplicationContext ac = new AnnotationConfigWebApplicationContext();
    ac.register(AppConfig.class);
    ac.refresh();

    DispatcherServlet servlet = new DispatcherServlet(ac);
    
    Dynamic registration = servletContext.addServlet("app6", servlet);
    registration.setLoadOnStartup(1);
    registration.addMapping("/app6/*");
    
  }
}
