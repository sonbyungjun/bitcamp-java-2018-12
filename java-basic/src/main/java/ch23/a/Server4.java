package ch23.a;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server4 {
  
  public static void main(String[] args) throws Exception {
    
    Scanner keyboard = new Scanner(System.in);
    
    ServerSocket serverSocket = new ServerSocket(8888, 3);
    
    System.out.println("서버 소켓 생성 완료!");
    System.out.println("클라이언트의 연결을 기다림!");
    
    while (true) {
      String input = keyboard.nextLine();
      if (input.equalsIgnoreCase("q"))
        break;
      
      Socket socket = serverSocket.accept();
      System.out.println("클라이언트와 연결되었음!");
      
    }
    
    
    serverSocket.close();
    System.out.println("서버 소켓을 닫음.");
    keyboard.close();
    
  }
  
}
