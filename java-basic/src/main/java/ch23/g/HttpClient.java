package ch23.g;

import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class HttpClient {
  
  public static void main(String[] args) {
    
    try (Socket socket = new Socket("www.neis.go.kr", 80);
        PrintStream out = new PrintStream(socket.getOutputStream());
        Scanner in = new Scanner(socket.getInputStream())) {
      
      out.println("GET / HTTP/1.1");
      out.println("host: www.neis.go.kr");
//      out.println("Connection: keep-alive");
//      out.println("Upgrade-Insecure-Requests: 1");
//      out.println("User-Agent: Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/72.0.3626.81 Safari/537.36");
//      out.println("Accept: text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8");
//      out.println("Accept-Encoding: gzip, deflate");
//      out.println("Accept-Language: ko-KR,ko;q=0.9,en-US;q=0.8,en;q=0.7");
      out.println();
      out.flush();
      
      while (true) {
      System.out.println(in.nextLine());
      }
      
    } catch (Exception e) {
      e.printStackTrace();
    }
    
  }
  
}
