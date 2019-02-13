package ch23.f;

import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {
  
  public static void main(String[] args) {
  
    try (Socket socket = new Socket("localhost", 8888);
        PrintStream out = new PrintStream(socket.getOutputStream());
        Scanner in = new Scanner(socket.getInputStream())) {
     
      System.out.println("서버와 연결됨!");
      
      out.println("hello");
      System.out.println("데이터 보냄!");
      
      String reponse = in.nextLine();
      System.out.println("데이터 받음!");
      
      System.out.println(reponse);
      
      
    } catch (Exception e) {
      e.printStackTrace();
    }
    
    
    
    
  }
  
}
