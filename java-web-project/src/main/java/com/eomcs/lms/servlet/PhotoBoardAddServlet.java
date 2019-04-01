package com.eomcs.lms.servlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.UUID;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import com.eomcs.lms.InitServlet;
import com.eomcs.lms.domain.PhotoBoard;
import com.eomcs.lms.domain.PhotoFile;
import com.eomcs.lms.service.PhotoBoardService;

@MultipartConfig(maxFileSize = 1024 * 1024 * 5)
@SuppressWarnings("serial")
@WebServlet("/photoboard/add")
public class PhotoBoardAddServlet extends HttpServlet {
  
  String uploadDir;
  
  @Override
  public void init() throws ServletException {
    this.uploadDir = this.getServletContext().getRealPath("/upload/photoboard");
  }
  
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();

    out.println("<html>");
    out.println("<head><title>사진게시판 등록</title></head>");
    out.println("<body>");
    out.println("<h1>사진게시판 등록</h1>");

    out.println("<form action='add' method='post' enctype='multipart/form-data'>");
    out.println("<table border='1'>");

    out.println("<tr>");
    out.println("<th>사진 제목<th>");
    out.println("<td><input type='text' name='title'></td>");
    out.println("</tr>");

    out.println("<tr>");
    out.println("<th>수업 번호<th>");
    out.println("<td><input type='text' name='lessonNo'></td>");
    out.println("</tr>");

    out.println("<tr>");
    out.println("최소 한개 이상 사진을 등록해야 합니다.");
    out.println("</tr>");

    out.println("<tr>");
    out.println("<th>사진1<th>");
    out.println("<td><input type='file' name='photo'></td>");
    out.println("</tr>");

    out.println("<tr>");
    out.println("<th>사진2<th>");
    out.println("<td><input type='file' name='photo'></td>");
    out.println("</tr>");

    out.println("<tr>");
    out.println("<th>사진3<th>");
    out.println("<td><input type='file' name='photo'></td>");
    out.println("</tr>");

    out.println("<tr>");
    out.println("<th>사진4<th>");
    out.println("<td><input type='file' name='photo'></td>");
    out.println("</tr>");

    out.println("<tr>");
    out.println("<th>사진5<th>");
    out.println("<td><input type='file' name='photo'></td>");
    out.println("</tr>");

    out.println("</table>");
    out.println("<p><button type='submit'>등록</button></p>");
    out.println("<p><a href='list'>목록</a></p>");
    out.println("</form>");
    out.println("</body>");
    out.println("</html>");
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    PhotoBoardService photoBoardService = InitServlet.iocContainer.getBean(PhotoBoardService.class);

    PhotoBoard board = new PhotoBoard();

    board.setTitle(request.getParameter("title"));
    board.setLessonNo(Integer.parseInt(request.getParameter("lessonNo")));

    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();

    out.println("<html><head>"
        + "<title>사진게시판등록</title>"
        + "<meta http-equiv='Refresh' content='1;url=list'>"
        + "</head>");
    out.println("<body><h1>사진게시판등록</h1>");

    ArrayList<PhotoFile> files = new ArrayList<>();
    Collection<Part> photos = request.getParts();
    for (Part photo : photos) {
      if (photo.getSize() == 0 || !photo.getName().equals("photo")) 
        continue;
      
      String filename = UUID.randomUUID().toString();
      photo.write(uploadDir + "/" + filename);
      
      PhotoFile file = new PhotoFile();
      file.setFilePath(filename);
      files.add(file);
    }
    board.setFiles(files);

    photoBoardService.add(board);
    out.println("<p>사진게시판 등록을 완료하였습니다.</p>");
    out.println("</body></html>");
  }

}
