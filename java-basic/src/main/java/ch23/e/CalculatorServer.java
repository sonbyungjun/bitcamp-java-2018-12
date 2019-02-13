package ch23.e;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;

public class CalculatorServer {
  public static void main(String[] args) {

    HashMap<Long, Integer> resultMap = new HashMap<>();

    try (ServerSocket serverSocket = new ServerSocket(8888)) {
      System.out.println("서버 실행 중...");

      while (true) {
        try (Socket socket = serverSocket.accept();
            BufferedReader in = new BufferedReader(
                new InputStreamReader(socket.getInputStream()));
            PrintStream out = new PrintStream(socket.getOutputStream());) {
          
          long sessionId = Long.parseLong(in.readLine());
          System.out.printf("세션 id : %d\n", sessionId);
          int result = 0;
          boolean isNewSessionId = false;
          
          if (sessionId == 0) {
            sessionId = System.currentTimeMillis();
            isNewSessionId = true;
          } else {
            result = resultMap.get(sessionId);
          }
          
          String request = in.readLine();

          if (request.equalsIgnoreCase("reset")) {
            resultMap.put(sessionId, 0);
            continue;
            
          } else if (request.equalsIgnoreCase("quit")) {
            out.printf("최종 결과 %d 입니다.\n", result);
            resultMap.remove(sessionId);
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

          resultMap.put(sessionId, result);
          
          if (isNewSessionId) {
            out.println(sessionId);
            out.flush();
          }
          
          out.printf("현재까지 결과는 %d 입니다.\n", result);
          out.flush();
          System.out.println("저장된 유저 저장소의 사이즈는 현재 "+resultMap.size());
          
        } catch (Exception e) {
          System.out.println("클라이언트와 통신 중 오류 발생!");
        }

      }

    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
