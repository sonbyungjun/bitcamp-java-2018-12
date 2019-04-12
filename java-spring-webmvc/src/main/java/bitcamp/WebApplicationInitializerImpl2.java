package bitcamp;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class WebApplicationInitializerImpl2 extends AbstractAnnotationConfigDispatcherServletInitializer {

  
  @Override
  protected String getServletName() {
    return "app7";
  }
  
  @Override
  protected Class<?>[] getRootConfigClasses() {
    return null;
  }

  @Override
  protected Class<?>[] getServletConfigClasses() {
    return new Class<?>[] {AppConfig.class};
  }

  @Override
  protected String[] getServletMappings() {
    return new String[] {"/app7/*"};
  }
  
  @Override
  public void onStartup(ServletContext servletContext) throws ServletException {
    System.out.println("WebApplicationInitializerImpl2.onStartup()...호출됨!");
    super.onStartup(servletContext);
  }
  
}
