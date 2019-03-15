package com.eomcs.lms.handler;
import java.util.HashMap;
import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import com.eomcs.lms.dao.PhotoBoardDao;
import com.eomcs.lms.domain.PhotoBoard;

public class PhotoBoardSearchCommand extends AbstractCommand {

  SqlSessionFactory sqlSessionFactory;

  public PhotoBoardSearchCommand(SqlSessionFactory sqlSessionFactory) {
    this.sqlSessionFactory = sqlSessionFactory;
  }

  @Override
  public void execute(Response response) throws Exception {

    try (SqlSession sqlSession = sqlSessionFactory.openSession()) {

      PhotoBoardDao photoBoardDao = sqlSession.getMapper(PhotoBoardDao.class);
      
      HashMap<String, Object> params = new HashMap<>();
      try {
        int lessonNo = response.requestInt("사진 파일 번호?");
        params.put("lessonNo", lessonNo);
      } catch(Exception e) {
      }
      try {
        String keyword = response.requestString("검색어?");
        if (keyword.length() > 0) 
          params.put("keyword", keyword);
      } catch(Exception e) {
      }

      List<PhotoBoard> photoPhotos = photoBoardDao.findAll(params);

      response.println("[검색 결과]");
      for (PhotoBoard photoPhoto : photoPhotos) {
        response.println(
            String.format("%3d, %-20s, %s, %d, %d", 
                photoPhoto.getNo(),
                photoPhoto.getTitle(), 
                photoPhoto.getCreatedDate(), 
                photoPhoto.getViewCount(), 
                photoPhoto.getLessonNo()));
      }
    }
  }

}
