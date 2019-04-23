package com.eomcs.lms.web.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import org.apache.ibatis.logging.LogFactory;

@WebListener
public class AppInitListener implements ServletContextListener {
  
  @Override
  public void contextInitialized(ServletContextEvent sce) {
    LogFactory.useLog4J2Logging();
  }
  
}
