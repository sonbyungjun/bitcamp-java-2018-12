package ch23.f;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class Server2 {

  public static void main(String[] args) {

    try (DatagramSocket socket = new DatagramSocket(8888)) {

      byte[] buf = new byte[8192];
      DatagramPacket emptyPacket = new DatagramPacket(buf, buf.length);
      
      socket.receive(emptyPacket);
      System.out.println("데이터 수신 완료!");
      
      String message = new String(
          emptyPacket.getData(),
           0,
          emptyPacket.getLength(),
          "UTF-8"
       );
      System.out.println(message);

    } catch (Exception e) {
      e.printStackTrace();
    }




  }

}
