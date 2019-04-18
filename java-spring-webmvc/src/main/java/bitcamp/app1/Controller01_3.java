package bitcamp.app1;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/c01_3")
public class Controller01_3 {
  
  @RequestMapping("h1")
  @ResponseBody
  public String handler() {
    return "h1";
  }
  
  @RequestMapping("/h2")
  @ResponseBody
  public String handler2() {
    return "h2";
  }
  
  @RequestMapping("h3")
  @ResponseBody
  public String handler3() {
    return "h3";
  }
  
  @RequestMapping("h4")
  @ResponseBody
  public String handler4() {
    return "h4";
  }
}
