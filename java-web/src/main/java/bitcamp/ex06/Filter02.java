package bitcamp.ex06;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;

@WebFilter(
    value="/ex06/*",
    initParams = {
        @WebInitParam(name="encoding", value="EUC-KR")
    })
public class Filter02 implements Filter {
  
  FilterConfig filterConfig;
  
  @Override
  public void init(FilterConfig filterConfig) throws ServletException {
    this.filterConfig = filterConfig;
  }
  
  @Override
  public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
      throws IOException, ServletException {
    
    System.out.printf("ex06.Filter02 : encoding=%s\n", filterConfig.getInitParameter("encoding"));
    
    chain.doFilter(request, response);
  }

}
