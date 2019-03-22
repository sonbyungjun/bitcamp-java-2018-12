// 18단계: DAO 구현체 자동 생성하기
// => java.lang.reflect.Proxy 를 이용하여 DAO 인터페이스를 구현한 객체를 자동으로 생성한다.
// 
// 작업:
// 1) DaoInvocationHandler 생성
//    => 실제 DAO 작업을 수행할 InvocationHandler 구현체를 만든다.
// 2) ApplicationInitializer 변경
//    => 기존에 생성한 DAO 구현체 대신 Proxy.newProxyInstance()가 생성한 DAO 구현체를 사용한다.
// 3) 매퍼 파일 변경
//    => namespace 이름을 DAO 인터페이스 이름(패키지명 포함)으로 변경한다.
//    => SQL ID 는 반드시 메서드명과 일치시킨다.
// 4) DaoFactory 생성
//    => DAO 구현체를 생성해주는 역할 수행.
//    => DaoInvocationHandler를 DaoFactory의 inner 클래스로 전환한다.
package com.eomcs.lms;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.ServerSocket;
import java.net.Socket;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.eomcs.lms.context.RequestMappingHandlerMapping;
import com.eomcs.lms.context.RequestMappingHandlerMapping.RequestMappingHandler;
import com.eomcs.lms.handler.Response;

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
        String request = in.readLine();

        // 클라이언트에게 응답하기
        RequestMappingHandler requestHandler = handlerMapping.get(request);

        if (requestHandler == null) {
          out.println("실행할 수 없는 명령입니다.");
          out.println("!end!");
          out.flush();
          return;
        }

        try {
          requestHandler.method.invoke(requestHandler.bean, new Response(in, out));
        } catch (Exception e) {
          out.printf("실행 오류! : %s\n", e.getMessage());
          e.printStackTrace();
        }

        out.println("!end!");
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









