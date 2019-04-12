package bitcamp;

import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

  @RequestMapping("/hello")
  @ResponseBody
  public String Hello(HttpServletResponse response) throws Exception {
    return "<html><body><h1>Hello!</h1></body></html>";
  }
  
  
  
}
