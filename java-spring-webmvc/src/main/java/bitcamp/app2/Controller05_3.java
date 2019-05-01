package bitcamp.app2;

import java.net.URLDecoder;
import java.util.Map;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/c05_3")
public class Controller05_3 {
  
  // http://localhost:8080/java-spring-webmvc/app2/c05_3/h1?no=1&title=ok&writer=kim&viewCount=100
  @RequestMapping(value="h1", produces="text/plain;charset=UTF-8")
  public Object handler1(int no, String title, String writer, int viewCount) {
    return String.format("%d, %s, %s, %d", no, title, writer, viewCount);
  }
  
  // http://localhost:8080/java-spring-webmvc/app2/c05_3/h2?no=1&title=ok&writer=kim&viewCount=100
  @RequestMapping(value="h2", produces="text/plain;charset=UTF-8")
  public Object handler2(Board board) {
    return board.toString();
  }
  
  // http://localhost:8080/java-spring-webmvc/html/app2/c05_3.html
  @RequestMapping(value="h3", produces="text/plain;charset=UTF-8")
  public Object handler3(@RequestBody String content) throws Exception {
    System.out.println(content);
    System.out.println(URLDecoder.decode(content, "UTF-8"));
    return "OK";
  }
  
  // http://localhost:8080/java-spring-webmvc/html/app2/c05_3.html
  @RequestMapping(value="h4", produces="text/plain;charset=UTF-8")
  public Object handler4(@RequestBody Map<String,Object> content) throws Exception {
    System.out.println(content);
    return "OK";
  }
  
  // http://localhost:8080/java-spring-webmvc/html/app2/c05_3.html
  @RequestMapping(value="h5", produces="text/plain;charset=UTF-8")
  public Object handler5(@RequestBody Board board) throws Exception {
    System.out.println(board);
    return "OK";
  }
  
}
