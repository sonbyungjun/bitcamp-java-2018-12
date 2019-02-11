package ch23.e;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;

public class CalculatorServer {
  public static void main(String[] args) {

    HashMap<Integer, Integer> ids = new HashMap<>();

    try (ServerSocket serverSocket = new ServerSocket(8888)) {
      System.out.println("서버 실행 중...");

      while (true) {

        try (Socket socket = serverSocket.accept();
            BufferedReader in = new BufferedReader(
                new InputStreamReader(socket.getInputStream()));
            PrintStream out = new PrintStream(socket.getOutputStream());) {
          
          int id = 0;
          int result = 0;

          if (id == 0 || ids.get(id) != null) {
            id = (int) (Math.random() * 100) + 1;
            out.println(id);
            ids.put(id, result);
            result = ids.get(id);
          }

          System.out.println("클라이언트와 연결됨! 요청처리 중...");

          String request = in.readLine();

          if (request.equalsIgnoreCase("quit")) {
            ids.put(id, 0);
            continue;
          }
          
          String[] input = request.split(" ");

          int b = 0;
          String op = null;

          try { 
            op = input[0];
            b = Integer.parseInt(input[1]);
          } catch (Exception e) {
            out.println("식의 형식이 바르지 않습니다.");
            out.flush();
            continue;
          }

          switch (op) {
            case "+": result += b; break;
            case "-": result -= b; break;
            case "*": result *= b; break;
            case "/": result /= b; break;
            case "%": result %= b; break;
            default:
              out.printf("%s 연산자를 지원하지 않습니다.\n", op);
              out.flush();
              continue;
          }

          out.printf("현재까지 결과는 %d 입니다.\n", result);
          out.flush();
          ids.put(id, result);
          

        } catch (Exception e) {
          System.out.println("클라이언트와 통신 중 오류 발생!");
        }

        System.out.println("클라이언트와 연결 끊음!");
      }

    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
