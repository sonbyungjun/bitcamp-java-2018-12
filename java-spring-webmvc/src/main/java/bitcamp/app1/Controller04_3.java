package bitcamp.app1;

import java.io.PrintWriter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/c04_3")
public class Controller04_3 {

  // http://localhost:8080/java-spring-webmvc/app1/c04_3/h1?model=sonata&maker=hyundai&capacity=5&auto=true
  
  @GetMapping("h1")
  @ResponseBody
  public void handler1(
      PrintWriter out,
      String model,
      String maker,
      int capacity,
      boolean auto,
      Car car) {
    
    out.printf("model=%s\n", model);
    out.printf("maker=%s\n", maker);
    out.printf("capacity=%s\n", capacity);
    out.printf("auto=%s\n", auto);
    out.printf("car=%s\n", car);
    
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
