package bitcamp.app1;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/c03_4")
public class Controller03_4 {
  
  @PostMapping(consumes = "application/x-www-form-urlencoded")
  @ResponseBody
  public String handler1() {
    return "handler1";
  }
  
  @PostMapping(consumes = "multipart/form-data")
  @ResponseBody
  public String handler2() {
    return "handler2";
  }
  
  @PostMapping(consumes = "text/csv")
  @ResponseBody
  public String handler3() {
    return "handler3";
  }
  
  @PostMapping(consumes = "application/json")
  @ResponseBody
  public String handler4() {
    return "handler4";
  }
  
  @RequestMapping
  @ResponseBody
  public String handler5() {
    return "handler5";
  }  
}
