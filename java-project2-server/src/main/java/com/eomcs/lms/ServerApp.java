package com.eomcs.lms;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.eomcs.lms.context.RequestMappingHandlerMapping;
import com.eomcs.lms.context.RequestMappingHandlerMapping.RequestMappingHandler;

@WebServlet("/*")
public class ServerApp implements Servlet {
  final static Logger logger = LogManager.getLogger(ServerApp.class);
  ApplicationContext icoContainer;
  RequestMappingHandlerMapping handlerMapping;
  ServletConfig config;

  @Override
  public void init(ServletConfig config) throws ServletException {
    this.config = config;
    logger.info("Spring IoC 컨테이너 준비");
    icoContainer = new AnnotationConfigApplicationContext(AppConfig.class);
    printBeans();

    logger.info("RequestMappingHandlerMapping 객체 준비");
    handlerMapping = (RequestMappingHandlerMapping) icoContainer.getBean(RequestMappingHandlerMapping.class);
  }

  @Override
  public void service(javax.servlet.ServletRequest req, javax.servlet.ServletResponse res)
      throws ServletException, IOException {
    logger.info("클라이언트 요청 들어옴.");

    HttpServletRequest request = (HttpServletRequest) req;
    HttpServletResponse response = (HttpServletResponse) res;
    
    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();

    String commandPath = request.getPathInfo();
    logger.info("클라이언트 요청: " + commandPath);

    RequestMappingHandler requestHandler = handlerMapping.get(commandPath);

    if (requestHandler == null) {
      out.println("실행할 수 없는 명령입니다.");
      return;
    }

    try {
      requestHandler.method.invoke(requestHandler.bean, request, response);
      
    } catch (Exception e) {
      out.printf("실행 오류! : %s\n", e.getMessage());
      e.printStackTrace();
    }
  }
  
  @Override
  public void destroy() {
  }
  
  @Override
  public ServletConfig getServletConfig() {
    return this.config;
  }
  
@Override
  public String getServletInfo() {
    return "Command 요청을 받아 처리하는 서블릿";
  }  
  

  private void printBeans() {
    String[] names = icoContainer.getBeanDefinitionNames();
    logger.debug("------------------------------------------------------------------------");
    for (String name : names) {
      logger.debug(String.format("빈 생성 됨 (객체명=%s, 클래스명=%s)", name, icoContainer.getBean(name).getClass().getName()));
    }
    logger.debug("------------------------------------------------------------------------");
  }
}