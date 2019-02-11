package ch23.test;

import java.net.ServerSocket;

public class CalculatorServer {

  public static void main(String[] args) {

    while (true) {
      try (ServerSocket serverSocket = new ServerSocket(8888)) {

        System.out.println("서버 실행 중 ...");

        while (true) {
          new CalculatorProcessor(serverSocket.accept()).execute();
        }

      } catch (Exception e) {
        System.out.println("클라이언트와 통신 중 오류 발생!");
        e.printStackTrace();
      }
    }
  }

}
