package bitcamp.app1;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/c03_1")
public class Controller03_1 {
  
  // http://localhost:8080/java-spring-webmvc/app1/c03_1?name=kim
  @GetMapping(params="name")
  @ResponseBody
  public String handler1() {
    return "handler1";
  }
  
  // http://localhost:8080/java-spring-webmvc/app1/c03_1?age=20
  @GetMapping(params="age")
  @ResponseBody
  public String handler2() {
    return "handler2";
  }
  
  // http://localhost:8080/java-spring-webmvc/app1/c03_1?name=kim&age=20
  @GetMapping(params={"age","name"})
  @ResponseBody
  public String handler3() {
    return "handler3";
  }
  
}
