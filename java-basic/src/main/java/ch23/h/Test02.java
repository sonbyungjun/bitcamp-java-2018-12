package ch23.h;

import java.net.URL;

public class Test02 {
  
  public static void main(String[] args) throws Exception{
  
    URL url = new URL("http://bitcamp.co.kr:80/a/b/c/index.html#side");
    
    System.out.printf("프로토콜: %s\n", url.getProtocol());
    System.out.printf("서버주소: %s\n", url.getHost());
    System.out.printf("포트번호: %s\n", url.getPort());
    System.out.printf("자원경로: %s\n", url.getPath());
    System.out.printf("내부위치: %s\n", url.getRef());
    
  }
  
}
