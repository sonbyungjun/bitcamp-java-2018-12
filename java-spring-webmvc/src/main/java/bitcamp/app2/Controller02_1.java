package bitcamp.app2;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/c02_1")
public class Controller02_1 {
  
  // http://localhost:8080/java-spring-webmvc/app2/c02_1?name=kim&age=20
  @GetMapping
  @ResponseBody
  public String handler1(String name, int age) {
    return String.format("name=%s, age=%d", name, age);
  }
  
  // http://localhost:8080/java-spring-webmvc/app2/c02_1/kim/20
  @GetMapping("{name}/{age}")
  @ResponseBody
  public String handler2(@PathVariable("name") String name,@PathVariable("age") int age) {
    return String.format("name=%s, age=%d", name, age);
  }
  
  // http://localhost:8080/java-spring-webmvc/app2/c02_1/kim_20
  @GetMapping("{name}_{age}")
  @ResponseBody
  public String handler3(
      /*
      @PathVariable("name") String name,
      @PathVariable("age") int age,
      */
      @PathVariable String name,
      @PathVariable int age
      ) {
    return String.format("name=%s, age=%d", name, age);
  }
  
}
