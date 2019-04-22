package bitcamp.app1;

import java.io.PrintWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/c04_6")
public class Controller04_6 {

  @GetMapping("h1")
  @ResponseBody
  public void handler1(
      PrintWriter out,
      @RequestHeader("Accept") String accept,
      @RequestHeader("User-Agent") String userAgent) {
    
    out.printf("accept=%s\n", accept);
    out.printf("User-Agent=%s\n", userAgent);
    
    if (userAgent.matches(".*Chrome.*")) {
      out.println("Chrome");
    } else if (userAgent.matches(".*Safari.*")) {
      out.println("Safari");
    } else if (userAgent.matches(".*Firefox.*")) {
      out.println("Firefox");
    } else {
      out.println("etc");
    }
    
  }
  
  public static void main(String[] args) {
    
    String str = "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_4) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/73.0.3683.103 Safari/537.36";
    
    //String regex = "Chrome";
    //String regex = "Chrome.*Safari";
    String regex = "^(Chrome).*Safari";
    Pattern pattern = Pattern.compile(regex);
    
    Matcher matcher = pattern.matcher(str);
    
    if (matcher.find()) {
      System.out.println("ok");
      for (int i = 0; i < matcher.groupCount(); i++) {
        System.out.println(matcher.group(i));
      }
    }
  }
  
}
