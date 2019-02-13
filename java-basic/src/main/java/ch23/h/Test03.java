package ch23.h;

import java.net.URL;

public class Test03 {
  
  public static void main(String[] args) throws Exception{
  
    URL url = new URL("file:///c:/Users/bitcamp/a.html");
    
    System.out.printf("프로토콜: %s\n", url.getProtocol());
    System.out.printf("서버주소: %s\n", url.getHost());
    System.out.printf("포트번호: %s\n", url.getPort());
    System.out.printf("자원경로: %s\n", url.getPath());
    
    System.out.println("-------------------------------------");
    
    url = new URL("file:///home/bitcamp/a.html");
    
    System.out.printf("프로토콜: %s\n", url.getProtocol());
    System.out.printf("서버주소: %s\n", url.getHost());
    System.out.printf("포트번호: %s\n", url.getPort());
    System.out.printf("자원경로: %s\n", url.getPath());
  }
  
}
