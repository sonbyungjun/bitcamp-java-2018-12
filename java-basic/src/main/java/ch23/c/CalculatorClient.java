package ch23.c;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class CalculatorClient {
  /*
  실행 예:
  - 클라이언트가 계산기 서버에 접속한 후 

  계산기 서버에 오신 걸 환영합니다! <== 서버의 응답
  계산식을 입력하세요! <== 서버의 응답
  예) 23 + 7 <== 서버의 응답
  > 23 + 7 <== 사용자의 입력. '>'문자는 클라이언트에서 출력한다.
  결과는 30 입니다. <== 서버의 응답
  > 23 ^ 7 <== 사용자의 입력. '>'문자는 클라이언트에서 출력한다.
  ^ 연산자를 지원하지 않습니다. <== 서버의 응답
  > ok + yes <== 사용자의 입력
  식의 형식이 잘못되었습니다. <== 서버의 응답
  > quit <== 사용자의 입력. '>'문자는 클라이언트에서 출력한다.
  안녕히 가세요! <== 서버의 응답

   */
  public static void main(String[] args) {

    try (Scanner keyboard = new Scanner(System.in);
        Socket socket = new Socket("localhost", 8888);
        DataOutputStream out = new DataOutputStream(socket.getOutputStream());
        DataInputStream in = new DataInputStream(socket.getInputStream())) {
      
      System.out.println(in.readUTF());
      
      while (true) {
      System.out.print("> ");
      String input = keyboard.nextLine();
      out.writeUTF(input);
      out.flush();
      System.out.println(in.readUTF());
      if (input.equals("quit"))
        break;
      }

    } catch (Exception e) {
      e.printStackTrace();
      
    }
  }
  
}
