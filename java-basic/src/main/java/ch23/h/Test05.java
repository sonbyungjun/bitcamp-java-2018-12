package ch23.h;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class Test05 {
  
  public static void main(String[] args) throws Exception{
  
    URL url = new URL("https://www.naver.com/");
    
    URLConnection con = url.openConnection();
    con.connect();
    
    BufferedReader in = new BufferedReader(
        new InputStreamReader(con.getInputStream()));
    
    while (true) {
      String str = in.readLine();
      if (str == null) 
        break;
      System.out.println(str);
    }
    
  }
  
}
