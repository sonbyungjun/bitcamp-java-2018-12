package ch23.b;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class Client1 {

  public static void main(String[] args) {

    try (Socket socket = new Socket("localhost", 8888);
        OutputStream out = socket.getOutputStream();
        InputStream in = socket.getInputStream()) {

      System.out.println("서버와 연결되었음!");
      
      out.write(100);
      System.out.println("서버에 데이터를 보냈음!");
      int response = in.read();
      System.out.println(response);

    } catch (Exception e) {
      e.printStackTrace();
    }

  }

}
