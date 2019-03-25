package com.eomcs.lms.handler;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;
import com.eomcs.lms.context.RequestMapping;
import com.eomcs.lms.domain.PhotoBoard;
import com.eomcs.lms.domain.PhotoFile;
import com.eomcs.lms.service.PhotoBoardService;

@Component
public class PhotoBoardCommand {

  PhotoBoardService photoBoardService;

  public PhotoBoardCommand(PhotoBoardService photoBoardService) {
    this.photoBoardService = photoBoardService;
  }

  @RequestMapping("/photoboard/list")
  public void list(ServletRequest request, ServletResponse response) {
    List<PhotoBoard> boards = photoBoardService.list(0, null);

    PrintWriter out = response.getWriter();
    out.println("<html><head><title>사진 게시판</title></head>");
    out.println("<body><h1>사진 게시판</h1>");
    out.println("<p><a href='/member/list'>회원목록</a>");
    out.println("<a href='/board/list'>게시판</a>");
    out.println("<a href='/lesson/list'>강의목록</a>");
    out.println("<a href='/photoboard/form'>사진게시판등록</a></p>");
    out.println("<table border='1'>");
    out.println("<tr> <th>번호</th><th>제목</th><th>강의제목</th><th>조회수</th><th>생성일</th></tr>");

    for (PhotoBoard board : boards) {
      out.printf("<tr><td>%1$d</td> "
          + "<td><a href='/photoboard/detail?no=%1$d'>%2$s</a></td> "
          + "<td>%3$s</td> "
          + "<td>%4$s</td> "
          + "<td>%5$s</td></tr>", 
          board.getNo(), 
          board.getTitle(),
          board.getLessonNo(),
          board.getViewCount(),
          board.getCreatedDate());
    }
    out.println("</table>");
    
    out.println("<form action='/photoboard/search'>");
    out.println("수업번호: <input type='text' name='lessonNo'> ");
    out.println("검색어: <input type='text' name='keyword'> ");
    out.println("<button type='submit'>검색</button>");
    out.println("</form>");
    
    out.println("</body></html>");
  }

  @RequestMapping("/photoboard/add")
  public void add(ServletRequest request, ServletResponse response) {
    PhotoBoard board = new PhotoBoard();
    board.setTitle(request.getParameter("title"));
    board.setLessonNo(Integer.parseInt(request.getParameter("lessonNo")));

    PrintWriter out = response.getWriter();

    out.println("<html><head>"
        + "<title>사진게시판등록</title>"
        + "<meta http-equiv='Refresh' content='1;url=/photoboard/list'>"
        + "</head>");
    out.println("<body><h1>사진게시판등록</h1>");

    ArrayList<PhotoFile> files = new ArrayList<>();

    for (int i = 1; i <= 5; i++) {
      String filePath = request.getParameter("photo" + i);
      if (filePath == null)
        break;
      PhotoFile file = new PhotoFile();
      file.setFilePath(filePath);
      files.add(file);
    }

    if (files.size() == 0) {
      out.println("<p>최소 한 개의 사진 파일을 등록해야 합니다.</p>");
      out.println("<meta http-equiv='Refresh' content='2;url=/photoboard/form'>");
      return;
    }

    board.setFiles(files);

    photoBoardService.add(board);
    out.println("<p>사진게시판 등록을 완료하였습니다.</p>");
    out.println("</body></html>");
  }

  @RequestMapping("/photoboard/detail")
  public void detail(ServletRequest request, ServletResponse response) throws Exception {
    int no = Integer.parseInt(request.getParameter("no"));

    PhotoBoard board = photoBoardService.get(no);

    PrintWriter out = response.getWriter();
    out.println("<html><head><title>사진게시판 상세조회</title></head>");
    out.println("<body><h1>사진게시판 상세조회</h1>");

    if (board == null) {
      response.println("<p>해당 사진게시판을 찾을 수 없습니다.</p>");
      return;
    }

    out.println("<form action='/photoboard/update'>");
    out.println("<table border='1'>");
    out.printf("<tr>"
        + "<th>번호</th>"
        + "<td><input type='text' name='no' value='%d' readonly></td>"
        + "</tr>\n", no);

    out.printf("<tr><th>제목</th> "
        + "<td><input type='text' name='title' value='%s'></td>"
        + "</tr>", board.getTitle());

    out.printf("<tr><th>작성일</th> "
        + "<td><input type='date' name='createdDate' value='%s'></td>"
        + "</tr>", board.getCreatedDate());

    out.printf("<tr><th>조회수</th> "
        + "<td><input type='text' name='viewCount' value='%d' readonly></td>"
        + "</tr>", board.getViewCount());

    out.printf("<tr><th>수업명</th> "
        + "<td><input type='text' name='totalHours' value='%s' readonly></td>"
        + "</tr>", board.getLesson().getTitle());
    
    out.printf("<tr><th>수업번호</th> "
        + "<td><input type='text' name='lessonNo' value='%s' readonly></td>"
        + "</tr>", board.getLesson().getNo());

    out.println(String.format("<tr><th>기간</th> "
        + "<td><input type='date' name='startDate' value='%s' readonly>~<input type='date' name='endDate' value='%s' readonly></td>"
        + "</tr>", board.getLesson().getStartDate(), board.getLesson().getEndDate()));

    out.println("<tr><th>사진파일</th> ");

    List<PhotoFile> files = board.getFiles();
    out.println("<td>");
    for (int i = 0; i < 5; i++) {
      if (i < files.size()) {
        out.printf("<input type='text' name='photo%d' value='%s'><br>", i+1, files.get(i).getFilePath());
      } else {
        out.printf("<input type='text' name='photo%s'><br>", i+1);
      }
    }
    out.println("</td>");
    out.println("</table>");

    out.printf("<p><a href='/photoboard/list'>사진게시판 목록</a>"
        + "<a href='/photoboard/delete?no=" + board.getNo() + "'>삭제</a>"
        + "<button type='submit'>변경</button>"
        + "</p>");

    out.println("</from>");
    out.println("</body></html>");

  }

  @RequestMapping("/photoboard/update")
  public void update(ServletRequest request, ServletResponse response) throws Exception {
    PhotoBoard board = new PhotoBoard();
    board.setNo(Integer.parseInt(request.getParameter("no")));
    board.setTitle(request.getParameter("title"));
    board.setLessonNo(Integer.parseInt(request.getParameter("lessonNo")));
    
    ArrayList<PhotoFile> files = new ArrayList<>();
    for (int i = 0; i < 5; i++) {
      String filename = request.getParameter("photo" + i);
      if (filename == null)
        continue;
      
      PhotoFile file = new PhotoFile();
      file.setFilePath(filename);
      file.setPhotoBoardNo(board.getNo());
      files.add(file);
    }
    board.setFiles(files);
    
    PrintWriter out = response.getWriter();
    out.println("<html><head>"
        + "<title>사진 변경</title>"
        + "<meta http-equiv='Refresh' content='1;url=/photoboard/list'>"
        + "</head>");
    out.println("<body><h1>사진 변경</h1>");
    
    if (files.size() == 0) {
      out.println("<p>최소 한 개의 사진 파일을 등록해야 합니다.</p>");
      
    } else {
      photoBoardService.update(board);
      out.println("<p>변경하였습니다.</p>");
    }
    out.println("</body></html>");
  }

  @RequestMapping("/photoboard/delete")
  public void delete(ServletRequest request, ServletResponse response) throws Exception {
    int no = Integer.parseInt(request.getParameter("no"));

    PrintWriter out = response.getWriter();

    out.println("<html><head>"
        + "<title>사진게시판 삭제</title>"
        + "<meta http-equiv='Refresh' content='1;url=/photoboard/list'>"
        + "</head>");
    out.println("<body><h1>사진게시판 삭제</h1>");

    if (photoBoardService.delete(no) == 0) {
      out.println("<p>해당 사진게시판이 없습니다.</p>");
    } else {
      out.println("<p>삭제했습니다.</p>");
    }
    out.println("</body></html>");
  }

  @RequestMapping("/photoboard/search")
  public void search(ServletRequest request, ServletResponse response) {
    int lessonNo = 0;
    try {
      lessonNo = Integer.parseInt(request.getParameter("lessonNo"));
    } catch (Exception e) { // 수업 번호를 입력하지 않거나 정상 입력이 아닌 경우는 무시한다.
    }
    
    String searchWord = null;
    try {
      String keyword = request.getParameter("keyword");
      if (keyword != null)
        searchWord = keyword;
    } catch (Exception e) { // 사용자가 검색어를 입력하지 않았으면 무시한다.
    }
    
    List<PhotoBoard> boards = photoBoardService.list(lessonNo, searchWord);
    
    PrintWriter out = response.getWriter();
    out.println("<html><head><title>사진 검색</title></head>");
    out.println("<body><h1>사진 검색 결과</h1>");
    out.println("<table border='1'>");
    out.println("<tr><th>번호</th><th>제목</th><th>등록일</th><th>조회수</th><th>수업</th></tr>");
    
    for (PhotoBoard board : boards) {
      out.println(String.format(
          "<tr><td>%d</td><td><a href='/photoboard/detail?no=%1$d'>%s</a>"
          + "</td><td>%s</td><td>%d</td><td>%d</td></tr>",
            board.getNo(), 
            board.getTitle(), 
            board.getCreatedDate(), 
            board.getViewCount(),
            board.getLessonNo()));
    }
    out.println("</table>");
    out.println("<p><a href='/photoboard/list'>목록</a></p>");
    out.println("</body>");
    out.println("</html>");
  }

  @RequestMapping("/photoboard/form")
  public void form(ServletRequest request, ServletResponse response) throws Exception {
    PrintWriter out = response.getWriter();
    out.println("<html>");
    out.println("<head><title>사진게시판 등록</title></head>");
    out.println("<body>");
    out.println("<h1>사진게시판 등록</h1>");

    out.println("<form action='/photoboard/add'>");
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
    out.println("<td><input type='text' name='photo1'></td>");
    out.println("</tr>");

    out.println("<tr>");
    out.println("<th>사진2<th>");
    out.println("<td><input type='text' name='photo2'></td>");
    out.println("</tr>");

    out.println("<tr>");
    out.println("<th>사진3<th>");
    out.println("<td><input type='text' name='photo3'></td>");
    out.println("</tr>");

    out.println("<tr>");
    out.println("<th>사진4<th>");
    out.println("<td><input type='text' name='photo4'></td>");
    out.println("</tr>");

    out.println("<tr>");
    out.println("<th>사진5<th>");
    out.println("<td><input type='text' name='photo5'></td>");
    out.println("</tr>");

    out.println("</table>");
    out.println("<p><button type='submit'>등록</button></p>");
    out.println("<p><a href='/photoboard/list'>목록</a></p>");
    out.println("</form>");
    out.println("</body>");
    out.println("</html>");
  }

}
