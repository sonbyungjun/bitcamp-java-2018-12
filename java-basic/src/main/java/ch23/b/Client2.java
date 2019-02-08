package ch23.b;

import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client2 {

  public static void main(String[] args) {

    try (Socket socket = new Socket("localhost", 8888);
        PrintWriter out = new PrintWriter(socket.getOutputStream());
        Scanner in = new Scanner(socket.getInputStream())) {

      System.out.println("서버와 연결되었음!");
      
      out.println("Hello");
      out.flush();
      System.out.println("서버에 데이터를 보냈음!");
      
      String response = in.nextLine();
      System.out.println(response);

    } catch (Exception e) {
      e.printStackTrace();
    }

  }

}
