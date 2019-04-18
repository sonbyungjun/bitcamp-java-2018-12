package bitcamp.app1;

import java.io.PrintWriter;
import javax.servlet.ServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/c04_2")
public class Controller04_2 {

  // http://localhost:8080/java-spring-webmvc/app1/c04_2/h1?name=kim
  
  @GetMapping("h1")
  @ResponseBody
  public void handler1(
      PrintWriter out,
      ServletRequest request,
      @RequestParam(value="name") String name1,
      @RequestParam(name="name") String name2,
      @RequestParam("name") String name3,
      String name) {
    
    out.printf("name=%s\n", request.getParameter("name"));
    out.printf("name=%s\n", name1);
    out.printf("name=%s\n", name2);
    out.printf("name=%s\n", name3);
    out.printf("name=%s\n", name);
    
  }
  
  // http://localhost:8080/java-spring-webmvc/app1/c04_2/h2?name1=kim&name2=park
  
  @GetMapping("h2")
  @ResponseBody
  public void handler2(
      PrintWriter out,
      @RequestParam("name1") String name1,
      String name2,
      @RequestParam(value="name3", required=false) String name3,
      @RequestParam(value="name4", defaultValue="ohora") String name4) {
    
    out.printf("name1=%s\n", name1);
    out.printf("name2=%s\n", name2);
    out.printf("name3=%s\n", name3);
    out.printf("name4=%s\n", name4);
    
  }
  
}
