package bitcamp;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.XmlWebApplicationContext;
import org.springframework.web.servlet.support.AbstractDispatcherServletInitializer;

public class WebApplicationInitializerImpl3 extends AbstractDispatcherServletInitializer {

  @Override
  protected WebApplicationContext createRootApplicationContext() {
      return null;
  }

  @Override
  protected WebApplicationContext createServletApplicationContext() {
      XmlWebApplicationContext cxt = new XmlWebApplicationContext();
      cxt.setConfigLocation("/WEB-INF/app8-servlet.xml");
      return cxt;
  }

  @Override
  protected String[] getServletMappings() {
      return new String[] { "/app8/*" };
  }
  
}
