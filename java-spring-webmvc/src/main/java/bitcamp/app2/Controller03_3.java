package bitcamp.app2;

import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

@Controller
@RequestMapping("/c03_3")
@SessionAttributes({"name2", "age2"})
public class Controller03_3 {

  // http://localhost:8080/java-spring-webmvc/app2/c03_3/h1
  @GetMapping(value="h1", produces="text/plain;charset=UTF-8")
  @ResponseBody
  public String handler1(HttpSession session) {
    return String.format("name=%s, age=%s, name2=%s, age2=%s",
        session.getAttribute("name"), session.getAttribute("age"), session.getAttribute("name2"), session.getAttribute("age2"));
  }
  
  //http://localhost:8080/java-spring-webmvc/app2/c03_3/h2
  @GetMapping(value="h2", produces="text/plain;charset=UTF-8")
  @ResponseBody
  public String handler2(HttpSession session) {
    session.invalidate();
    return "session.invalidate()";
  }
  
  //http://localhost:8080/java-spring-webmvc/app2/c03_3/h3
  @GetMapping(value="h3", produces="text/plain;charset=UTF-8")
  @ResponseBody
  public String handler3(SessionStatus status) {
    status.setComplete();
    return "status.setComplete()";
  }
  
}
