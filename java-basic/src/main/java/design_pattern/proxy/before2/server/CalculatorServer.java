package design_pattern.proxy.before2.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class CalculatorServer {

  public static void main(String[] args) {

    Calculator calc = new Calculator();

    try (ServerSocket ss = new ServerSocket(8888)) {
      System.out.println("서버 실행 중...");

      while (true) {
        try (Socket socket = ss.accept();
            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream())) {

          int a = in.readInt();
          int b = in.readInt();
          String op = in.readUTF();

          switch (op) {
            case "+":
              out.writeUTF("OK");
              out.writeInt(calc.plus(a, b));
              break;
            case "-":
              out.writeUTF("OK");
              out.writeInt(calc.minus(a, b));
              break;
            default:
              out.writeUTF("FAIL");
              out.writeUTF("해당 연산자를 지원하지 않습니다.");
          }
          out.flush();

        } catch (Exception e) {
          System.out.println("클라이언트 요청 처리 중에 오류 발생!");
        }
        
      } // while server

    } catch (Exception e) {
      e.printStackTrace();
    }

  }

}
