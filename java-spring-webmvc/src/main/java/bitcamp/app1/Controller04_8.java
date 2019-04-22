package bitcamp.app1;

import java.io.File;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.UUID;
import javax.servlet.ServletContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/c04_8")
public class Controller04_8 {

  @Autowired ServletContext sc;

  @PostMapping(value="h1", produces="text/html;charset=UTF-8")
  @ResponseBody
  public String handler1(
      String name,
      int age,
      MultipartFile photo) throws Exception {

    String filename = null;
    if (!photo.isEmpty()) {
      filename = UUID.randomUUID().toString();
      String path = sc.getRealPath("/html/app1/" + filename);
      photo.transferTo(new File(path));
    }
    return
        "<html><head><title>c04_8/h1</title></head><body>" + 
        "<h1>업로드 결과</h1>" + 
        "<p>이름:" + name + "</p>" +
        "<p>나이:" + age + "</p>" +
        (filename != null ? "<p><img src='../../html/app1/" + filename + "'></p>" : "") +
        "</body></html>";
  }


  @PostMapping(value="h2", produces="text/html;charset=UTF-8")
  @ResponseBody
  public String handler2(
      String name,
      int age,
      MultipartFile[] photo) throws Exception {

    StringWriter out0 = new StringWriter();
    PrintWriter out = new PrintWriter(out0);
    
    out.println("<html><head><title>c04_8/h2</title></head><body>\n");
    out.println("<h1>업로드 결과</h1>");
    out.printf("<p>이름: %s</p>\n", name);
    out.printf("<p>나이: %s</p>\n", age);
    String filename = null;
    for (MultipartFile f : photo) {
      if (!f.isEmpty()) {
        filename = UUID.randomUUID().toString();
        String path = sc.getRealPath("/html/app1/" + filename);
        f.transferTo(new File(path));
        out.printf("<p><img src='../../html/app1/%s'</p>", filename);
      }
    }
    out.println("</body></html>");
    
    return out0.toString();
  }

}
