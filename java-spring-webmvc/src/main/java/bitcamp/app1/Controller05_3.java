package bitcamp.app1;

import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/c05_3")
public class Controller05_3 {
  
  // http://localhost:8080/java-spring-webmvc/app1/c05_2/h1
  
  @GetMapping("h1")
  public String handler1(
      HttpServletRequest request) throws Exception {
    request.setAttribute("name", "홍길동");
    request.setAttribute("age", 20);
    request.setAttribute("working", true);
    return "/WEB-INF/jsp/c05_3.jsp";
  }
  
  @GetMapping("h2")
  public String handler2(
      Map<String,Object> map) throws Exception {
    map.put("name", "홍길동");
    map.put("age", 20);
    map.put("working", true);
    return "/WEB-INF/jsp/c05_3.jsp";
  }
  
  @GetMapping("h3")
  public String handler3(
      Model model) throws Exception {
    model.addAttribute("name", "홍길동");
    model.addAttribute("age", 20);
    model.addAttribute("working", true);
    return "/WEB-INF/jsp/c05_3.jsp";
  }
  
  @GetMapping("h4")
  public ModelAndView handler4() throws Exception {
    ModelAndView mv = new ModelAndView();
    mv.addObject("name", "홍길동");
    mv.addObject("age", 20);
    mv.addObject("working", true);
    mv.setViewName("/WEB-INF/jsp/c05_3.jsp");
    return mv;
  }
  
}
