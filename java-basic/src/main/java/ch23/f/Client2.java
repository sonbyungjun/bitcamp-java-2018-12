package ch23.f;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Client2 {

  @SuppressWarnings("static-access")
  public static void main(String[] args) {

    try (DatagramSocket socket = new DatagramSocket()) {

      for (int i = 0; i < 100; i++) {
        byte[] bytes = String.format("Hello! - %d", i).getBytes("UTF-8");
        DatagramPacket packet = new DatagramPacket(
            bytes,
            bytes.length,
            InetAddress.getByName("localhost"),
              8888
            );
        socket.send(packet);
        System.out.println(i + " - 데이터 전송 완료!(단 상대편이 해당 패킷을 받았는지는 보장 못함)");
        
        Thread.currentThread().sleep(500);
      }

    } catch (Exception e) {
      e.printStackTrace();
    }




  }

}
