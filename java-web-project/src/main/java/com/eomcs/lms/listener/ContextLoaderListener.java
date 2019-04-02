package com.eomcs.lms.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.eomcs.lms.AppConfig;

@WebListener
public class ContextLoaderListener implements ServletContextListener {
  
  final static Logger logger = LogManager.getLogger(ContextLoaderListener.class);
  
  @Override
  public void contextInitialized(ServletContextEvent sce) {
    logger.info("Spring IoC 컨테이너 준비");
    ApplicationContext iocContainer = new AnnotationConfigApplicationContext(AppConfig.class);
    printBeans(iocContainer);
    
    ServletContext sc = sce.getServletContext();
    sc.setAttribute("iocContainer", iocContainer);
  }

  private void printBeans(ApplicationContext iocContainer) {
    String[] names = iocContainer.getBeanDefinitionNames();
    logger.debug("------------------------------------------------------------------------");
    for (String name : names) {
      logger.debug(String.format("빈 생성 됨 (객체명=%s, 클래스명=%s)", name, iocContainer.getBean(name).getClass().getName()));
    }
    logger.debug("------------------------------------------------------------------------");
  }
  
}
