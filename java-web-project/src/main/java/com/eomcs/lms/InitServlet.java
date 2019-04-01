package com.eomcs.lms;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.eomcs.lms.context.RequestMappingHandlerMapping;

@SuppressWarnings("serial")
@WebServlet(urlPatterns="/init", loadOnStartup = 1)
public class InitServlet extends HttpServlet {
  
  final static Logger logger = LogManager.getLogger(InitServlet.class);
  public static ApplicationContext iocContainer;
  RequestMappingHandlerMapping handlerMapping;
  
  @Override
  public void init() throws ServletException {
    logger.info("Spring IoC 컨테이너 준비");
    iocContainer = new AnnotationConfigApplicationContext(AppConfig.class);
    printBeans();

    logger.info("RequestMappingHandlerMapping 객체 준비");
    handlerMapping = (RequestMappingHandlerMapping) iocContainer.getBean(RequestMappingHandlerMapping.class);
  }

  private void printBeans() {
    String[] names = iocContainer.getBeanDefinitionNames();
    logger.debug("------------------------------------------------------------------------");
    for (String name : names) {
      logger.debug(String.format("빈 생성 됨 (객체명=%s, 클래스명=%s)", name, iocContainer.getBean(name).getClass().getName()));
    }
    logger.debug("------------------------------------------------------------------------");
  }
}