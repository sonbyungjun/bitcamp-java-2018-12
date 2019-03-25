package com.eomcs.lms;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.ServerSocket;
import java.net.Socket;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.eomcs.lms.context.RequestMappingHandlerMapping;
import com.eomcs.lms.context.RequestMappingHandlerMapping.RequestMappingHandler;
import com.eomcs.lms.handler.ServletRequest;
import com.eomcs.lms.handler.SevletResponse;

public class ServerApp {

  final static Logger logger = LogManager.getLogger(ServerApp.class);
  ApplicationContext icoContainer;
  RequestMappingHandlerMapping handlerMapping;

  public void service() throws Exception {
    try (ServerSocket ss = new ServerSocket(8888)) {

      logger.info("서버 실행 중...");
      
      icoContainer = new AnnotationConfigApplicationContext(AppConfig.class);
      printBeans();

      handlerMapping = (RequestMappingHandlerMapping) icoContainer.getBean(RequestMappingHandlerMapping.class);


      while (true) {
        new RequestHandlerThread(ss.accept()).start();
      } // while


    } catch (Exception e) {
      e.printStackTrace();
    } // try(ServerSocket)

  }

  public static void main(String[] args) throws Exception {
    ServerApp app = new ServerApp();

    // App 을 실행한다.
    app.service();
  }

  // 바깥 클래스(ServerApp)의 인스턴스 필드를 사용해야 한다면 
  // Inner 클래스(non-static nested class)로 정의하라!
  // 
  class RequestHandlerThread extends Thread {

    Socket socket;

    public RequestHandlerThread(Socket socket) {
      this.socket = socket;
    }

    @Override
    public void run() {
      logger.info("클라이언트 연결 되었음.");
      
      try (Socket socket = this.socket;
          BufferedReader in = new BufferedReader(
              new InputStreamReader(socket.getInputStream()));
          PrintWriter out = new PrintWriter(socket.getOutputStream())) {

        // 클라이언트의 요청 읽기
        String requestLine = in.readLine();
        logger.debug(requestLine);
        
        while (true) {
         String str = in.readLine();
         if (str.length() == 0)
           break;
        }
        
        String[] requestURI = requestLine.split(" ")[1].split("\\?");
        String cammandPath = requestURI[0];
        
        // 클라이언트에게 응답하기
        
        RequestMappingHandler requestHandler = handlerMapping.get(cammandPath);

        if (requestHandler == null) {
          out.println("HTTP/1.1 404 Not Found");
          out.println("Server: bitcamp");
          out.println("Content-Type: text/html; charset=UTF-8");
          out.println();
          out.println("실행할 수 없는 명령입니다.");
          out.flush();
          return;
        }

        try {
          
          ServletRequest request = new ServletRequest();
          if (requestURI.length > 1) {
            request.setQueryString(requestURI[1]);
          }
          SevletResponse response = new SevletResponse(in, out);
          
          out.println("HTTP/1.1 200 OK");
          out.println("Server: bitcamp");
          out.println("Content-Type: text/html; charset=UTF-8");
          out.println();
          requestHandler.method.invoke(requestHandler.bean, request, response);
        } catch (Exception e) {
          out.printf("실행 오류! : %s\n", e.getMessage());
          e.printStackTrace();
        }

        out.flush();

      } catch (Exception e) {
        logger.error("명령어 실행 중 오류 발생 : " + e.toString());
        StringWriter strWriter = new StringWriter();
        PrintWriter out = new PrintWriter(strWriter);
        e.printStackTrace(out);
        logger.error(strWriter.toString());

      }
      logger.info("클라이언트와 연결 종료.");
    }
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









