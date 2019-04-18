package bitcamp.app1;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/c03_3")
public class Controller03_3 {
  
  @GetMapping(produces = "text/plain")
  @ResponseBody
  public String handler1() {
    return "handler1";
  }
  
  @GetMapping(produces = "text/html")
  @ResponseBody
  public String handler2() {
    return "handler2";
  }
  
  @GetMapping(produces = "application/json")
  @ResponseBody
  public String handler3() {
    return "handler3";
  }
  
  @GetMapping
  @ResponseBody
  public String handler4() {
    return "handler4";
  }
  
}
