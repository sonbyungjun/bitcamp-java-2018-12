package ch23.f;

import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {

  public static void main(String[] args) {

    try (ServerSocket ss = new ServerSocket(8888)) {

      while (true) {
        
        try (Socket socket = ss.accept();
            PrintStream out = new PrintStream(socket.getOutputStream());
            Scanner in = new Scanner(socket.getInputStream())) {

          System.out.println("클라이언트 연결됨!");

          String request = in.nextLine();
          System.out.println("데이터 받음!");

          out.println("**" + request + "**");
          System.out.println("데이터 보냄!");

        } catch (Exception e) {
          e.printStackTrace();
        }
      } // while
      
    } catch (Exception e) {
      e.printStackTrace();
    }



  }

}
