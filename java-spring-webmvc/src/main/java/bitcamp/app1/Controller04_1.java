package bitcamp.app1;

import java.io.PrintWriter;
import java.util.Map;
import javax.servlet.ServletContext;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/c04_1")
public class Controller04_1 {
  
  @Autowired
  ServletContext sc;
  
  @GetMapping("h1")
  @ResponseBody
  public void handler1(
      //ServletContext sc,
      ServletRequest request, 
      ServletResponse reponse,
      HttpServletRequest request2, 
      HttpServletResponse reponse2,
      HttpSession session,
      Map<String,Object> map,
      Model model,
      PrintWriter out) {
    
    out.printf("ServletContext: %b\n", sc != null);
    out.printf("ServletRequest: %b\n", request != null);
    out.printf("ServletResponse: %b\n", reponse != null);
    out.printf("HttpServletRequest: %b\n", request2 != null);
    out.printf("HttpServletResponse: %b\n", reponse2 != null);
    out.printf("HttpSession: %b\n", session != null);
    out.printf("Map: %b\n", map != null);
    out.printf("Model: %b\n", model != null);
    
  }
  
}
