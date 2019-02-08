package ch23.a;

import java.net.Socket;
import java.util.Scanner;

public class Client2 {

  public static void main(String[] args) throws Exception{
    
    Scanner keyboard = new Scanner(System.in);
    
    Socket socket = new Socket("localhost", 8888);
    System.out.println("서버와 연결되었음!");

    keyboard.nextLine();
    
    socket.close();
    System.out.println("서버와의 연결을 끊었음.");
    keyboard.close();
  }

}
