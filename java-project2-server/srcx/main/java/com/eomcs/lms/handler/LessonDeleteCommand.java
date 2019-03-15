package com.eomcs.lms.handler;
import java.util.HashMap;
import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import com.eomcs.lms.dao.LessonDao;
import com.eomcs.lms.dao.PhotoBoardDao;
import com.eomcs.lms.dao.PhotoFileDao;
import com.eomcs.lms.domain.PhotoBoard;

public class LessonDeleteCommand extends AbstractCommand {

  SqlSessionFactory sqlSessionFactory;

  public LessonDeleteCommand(SqlSessionFactory sqlSessionFactory) {
    this.sqlSessionFactory = sqlSessionFactory;
  }

  @Override
  public void execute(Response response) throws Exception {
    
    SqlSession sqlSession = sqlSessionFactory.openSession();
    
    try {
      
      LessonDao lessonDao = sqlSession.getMapper(LessonDao.class);
      PhotoBoardDao photoBoardDao = sqlSession.getMapper(PhotoBoardDao.class);
      PhotoFileDao photoFileDao = sqlSession.getMapper(PhotoFileDao.class);

      int no = response.requestInt("번호?");

      HashMap<String, Object> params = new HashMap<>();
      params.put("lessonNo", no);
      List<PhotoBoard> boards = photoBoardDao.findAll(params);
      for (PhotoBoard board : boards) {
        photoFileDao.deleteByPhotoBoardNo(board.getNo());
        photoBoardDao.delete(board.getNo());
      }

      if (lessonDao.delete(no) == 0) {
        response.println("해당 수업을 찾지 못했습니다.");
        return;
      }
      response.println("수업을 삭제했습니다.");
      sqlSession.commit();
    } catch(Exception e) {
      sqlSession.rollback();
      response.println("삭제 중 오류 발생.");
    } finally {
      sqlSession.close();
    }
  }

}
