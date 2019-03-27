package bitcamp.ex01;

import java.io.IOException;
import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;


public class Servlet01 implements Servlet {
  
  ServletConfig config;
  
  @Override
  public void init(ServletConfig config) throws ServletException {
    this.config = config;
    System.out.println("Servlet01.init(ServletConfig)");
  }
  
  @Override
  public void service(ServletRequest req, ServletResponse res)
      throws ServletException, IOException {
    System.out.println("Servlet01.service(ServletRequest, ServletResponse)");
  }
  
  @Override
  public void destroy() {
    System.out.println("Servlet01.destroy()");
  }
  
  @Override
  public ServletConfig getServletConfig() {
    System.out.println("Servlet01.getServletConfig()");
    return this.config;
  }
  
  @Override
  public String getServletInfo() {
    System.out.println("Servlet01.getServletInfo()");
    return "Servlet01";
  }
}
