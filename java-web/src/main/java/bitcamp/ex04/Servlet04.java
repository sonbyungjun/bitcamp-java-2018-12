package bitcamp.ex04;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;
import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

@WebServlet("/ex04/s4")
public class Servlet04 extends GenericServlet {

  private static final long serialVersionUID = 1L;
  private String uploadDir;

  @Override
  public void init() throws ServletException {
    this.uploadDir = this.getServletContext().getRealPath("/upload");
  }

  @Override
  public void service(ServletRequest req, ServletResponse res)
      throws ServletException, IOException {

    //req.setCharacterEncoding("UTF-8");
    /*
   String name = req.getParameter("name");
   String age = req.getParameter("age");
   String photo = req.getParameter("photo");

    res.setContentType("text/plain;charset=UTF-8");
    PrintWriter out = res.getWriter();

    out.printf("이름=%s\n", name);
    out.printf("나이=%s\n", age);
    out.printf("사진=%s\n", photo);
     */

    DiskFileItemFactory fileItemFactory = new DiskFileItemFactory();

    ServletFileUpload multipartDataHandler = new ServletFileUpload(fileItemFactory);

    HashMap<String,String> paramMap = new HashMap<>();

    try {

      List<FileItem> parts = multipartDataHandler.parseRequest((HttpServletRequest) req);

      for (FileItem part : parts) {
        if (part.isFormField()) {
          paramMap.put(part.getFieldName(), part.getString("UTF-8"));

        } else {
          String filename = UUID.randomUUID().toString();
          
          File file = new File(this.uploadDir + "/" + filename);
          
          part.write(file);
          
          paramMap.put(part.getFieldName(), filename);
        }
      }

    } catch (Exception e) {
      e.printStackTrace();
    }

    res.setContentType("text/html;charset=UTF-8");
    PrintWriter out = res.getWriter();
    out.println("<html>");
    out.println("<head>");
    out.println("  <meta charset='UTF-8'>");
    out.println("  <title>Servlet04</title>");
    out.println("</head>");
    out.println("<body><h1>파일 업로드 결과</h1>");
    out.printf("이름=%s<br>\n", paramMap.get("name"));
    out.printf("나이=%s<br>\n", paramMap.get("age"));
    out.printf("사진=%s<br>\n", paramMap.get("photo"));
    out.printf("<img src='../upload/%s'><br>\n", paramMap.get("photo")); 
    out.println("</body></html>");
    
  }
}