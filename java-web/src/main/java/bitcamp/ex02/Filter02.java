package bitcamp.ex02;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;


public class Filter02 implements Filter {
  
  @Override
  public void init(FilterConfig filterConfig) throws ServletException {
    System.out.println("Filter02.init()");
  }
  
  @Override
  public void destroy() {
    System.out.println("Filter02.destroy()");
  }
  
  @Override
  public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
      throws IOException, ServletException {
    
    System.out.println("Filter02.doFilter() : 시작");
    
   chain.doFilter(request, response);
    
    System.out.println("Filter02.doFilter() : 종료");
    
  }
}
