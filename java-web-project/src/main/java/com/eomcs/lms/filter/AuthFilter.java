package com.eomcs.lms.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.eomcs.lms.domain.Member;

@WebFilter("/*")
public class AuthFilter implements Filter {
  
  FilterConfig filterConfig;
  String contextRootPath;
  
  @Override
  public void init(FilterConfig filterConfig) throws ServletException {
    this.filterConfig = filterConfig;
    contextRootPath = filterConfig.getServletContext().getContextPath();
  }
  
  @Override
  public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
      throws IOException, ServletException {
    
    HttpServletRequest httpReq = (HttpServletRequest) request;
    HttpServletResponse httpResp = (HttpServletResponse) response;
    
    String servletPath = httpReq.getServletPath();
    
    if (servletPath.endsWith("add")
        || servletPath.endsWith("update")
        || servletPath.endsWith("delete")) {
      
      Member loginUser = (Member) httpReq.getSession().getAttribute("loginUser");
      
      if (loginUser == null) {
        httpResp.sendRedirect(contextRootPath + "/auth/login");
        return;
      }
      
    }
    
    chain.doFilter(request, response);
  }
}
