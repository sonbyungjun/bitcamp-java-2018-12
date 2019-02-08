package ch23.a;

import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.util.Scanner;

public class Client4 {

  public static void main(String[] args) throws Exception{
    
    Scanner keyboard = new Scanner(System.in);
    
    Socket socket = new Socket();
    System.out.println("소켓 생성됨.");
    
    SocketAddress socketAddress = new InetSocketAddress("localhost", 8888);
    
    System.out.println("서버와 연결 중...");
    socket.connect(socketAddress, 20000);
    System.out.println("서버와 연결되었음!");
    
    keyboard.nextLine();
    
    socket.close();
    System.out.println("서버와의 연결을 끊었음.");
    keyboard.close();
  }

}
