package design_pattern.proxy.before2.client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

public class CalculatorClient {

  public int compute(int a, int b, String op) throws Exception {

    try (Socket socket = new Socket("localhost", 8888);
        DataOutputStream out = new DataOutputStream(socket.getOutputStream());
        DataInputStream in = new DataInputStream(socket.getInputStream())) {
      
      out.writeInt(a);
      out.writeInt(b);
      out.writeUTF(op);
      out.flush();

      if (in.readUTF().equalsIgnoreCase("OK")) 
        return in.readInt();
      else 
        throw new RuntimeException(in.readUTF());

    } 
  }
  
}
