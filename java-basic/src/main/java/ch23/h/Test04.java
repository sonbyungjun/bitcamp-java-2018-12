package ch23.h;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

public class Test04 {
  
  public static void main(String[] args) throws Exception{
  
    URL url = new URL("https://www.naver.com/");
    
    BufferedReader in = new BufferedReader(
        new InputStreamReader(url.openStream()));
    
    while (true) {
      String str = in.readLine();
      if (str == null) 
        break;
      System.out.println(str);
    }
    
  }
  
}
