package ch23.c;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

public class CalculatorProcessor {

  Socket socket;
  DataOutputStream out;
  DataInputStream in;

  public CalculatorProcessor(Socket socket) throws Exception {
    this.socket = socket;
    this.out = new DataOutputStream(socket.getOutputStream());
    this.in = new DataInputStream(socket.getInputStream());
  }

  public void execute() throws Exception {
    try (Socket socket = this.socket;
        DataOutputStream out = this.out;
        DataInputStream in = this.in) {

      sendGreeting();

      while (true) {
        String[] input = in.readUTF().split(" ");
        if (isQuit(input[0]))
          break;

        Calculate(input);
      }
    }
  }

  private void sendGreeting() throws Exception {
    out.writeUTF("계산기 서버에 오신 걸 환영합니다!\n계산식을 입력하세요!\n예) 23 + 7\n");
    out.flush();
  }

  private void Calculate(String[] input) {
    String output;
    long first = 0;
    long last = 0;
    long result = 0;
    try {
      
      if (input.length > 3)
        throw new Exception();
      first = Integer.parseInt(input[0]);
      last = Integer.parseInt(input[2]);
      
      switch (input[1]) {
        case "+": result = first + last; break;
        case "-": result = first - last; break;
        case "*": result = first * last; break;
        case "%": result = first % last; break;
        case "/": result = first / last; break;
        default :
          out.writeUTF(input[1] + " 연산자를 지원하지 않습니다.");
          out.flush();
      }
      
      output = "결과는 " + result + "입니다.";
      out.writeUTF(output);
      out.flush();
      
    } catch (Exception e) {
      try {
        out.writeUTF("식의 형식이 잘못되었습니다.");
        out.flush();
      } catch (Exception e2) {}
    }
    
  }

  private boolean isQuit(String request) throws Exception {
    if (request.equals("quit")) {
      out.writeUTF("안녕히 가세요!");
      out.flush();
      return true;
    }
    return false;
  }

}
