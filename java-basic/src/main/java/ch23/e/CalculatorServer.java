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
          
          int id = Integer.parseInt(in.readLine());
          int result = 0;
          
          if (id == 0) {
            id = (int) (Math.random() * 100000) + 1;
            out.println(id);
            out.flush();
            System.out.printf("아이디 생성됨 id : %d\n", id, result);
            ids.put(id, result);
            
          } else if (ids.get(id) != null) {
            result = ids.get(id);
            System.out.printf("값 꺼내옴 result : %d\n", result);
            
          }
          
          String request = in.readLine();

          if (request.equalsIgnoreCase("reset")) {
            ids.put(id, 0);
            continue;
            
          } else if (request.equalsIgnoreCase("quit")) {
            out.printf("최종 결과 %d 입니다.\n", result);
            ids.remove(id);
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
          System.out.println("저장된 유저 저장소의 사이즈는 현재 "+ids.size());
          
        } catch (Exception e) {
          System.out.println("클라이언트와 통신 중 오류 발생!");
        }

      }

    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
