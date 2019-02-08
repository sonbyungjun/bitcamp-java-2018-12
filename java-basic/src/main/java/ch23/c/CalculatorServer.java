package ch23.c;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class CalculatorServer {

  public static void main(String[] args) {

    try (ServerSocket serverSocket = new ServerSocket(8888)) {

      try (Socket socket = serverSocket.accept();
          DataOutputStream out = new DataOutputStream(socket.getOutputStream());
          DataInputStream in = new DataInputStream(socket.getInputStream())) {

        out.writeUTF("계산기 서버에 오신 걸 환영합니다!\n계산식을 입력하세요!\n예) 23 + 7");
        out.flush();
        
        int result = 0;
        String output;

        while (true) {
          String input = in.readUTF();
          if (input.equals("quit")) {
            out.writeUTF("안녕히 가세요!");
            out.flush();
            break;
          } 
          String[] strs = null;
          int first = 0;
          int last = 0;
          
          try {
          strs = input.split(" ");
          first = Integer.parseInt(strs[0]);
          last = Integer.parseInt(strs[2]);
          } catch (Exception e) {
            out.writeUTF("식의 형식이 잘못되었습니다.");
            out.flush();
            continue;
          }
          
          switch (strs[1]) {
            case "+":
              result = first + last;
              output = "결과는 " + result + "입니다.";
              break;
            case "-":
              result = first - last;
              output = "결과는 " + result + "입니다.";
              break;
            case "*":
              result = first * last;
              output = "결과는 " + result + "입니다.";
              break;
            case "%":
              result = first % last;
              output = "결과는 " + result + "입니다.";
              break;
            case "/":
              result = first / last;
              output = "결과는 " + result + "입니다.";
              break;
              default :
                output = strs[1] + " 연산자는 지원하지 않습니다.";
          }
          
          out.writeUTF(output);
          out.flush();
        }

      } 
      
      System.out.println("클라이언트와의 연결을 끊었음.");
    } catch (Exception e) {
      e.printStackTrace();
    }
    System.out.println("서버 종료!");
  }


}
