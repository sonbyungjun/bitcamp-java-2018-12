package ch23.b;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server1 {
  
  public static void main(String[] args) {
    try (Scanner keyboard = new Scanner(System.in);
        ServerSocket serverSocket = new ServerSocket(8888)) {
      
      try (Socket socket = serverSocket.accept();
      OutputStream out = socket.getOutputStream();
      InputStream in = socket.getInputStream()) {
        
      System.out.println("대기열에서 클라이언트 정보를 꺼내 소켓을 생성하였음.");
      System.out.println("클라이언트와 통신할 입출력 스트림이 준비되었음.");
      
      System.out.println("데이터를 읽기 전에 잠깐!");
      keyboard.nextLine();
      
      int request = in.read();
      System.out.println(request);
      
      out.write(100 / 3);
      System.out.println("클라이언트에게 데이터를 보냈음.");
     
      } 
      System.out.println("클라이언트와의 연결을 끊었음.");
    } catch (Exception e) {
      e.printStackTrace();
    }
    System.out.println("서버 종료!");
  }
  
}
