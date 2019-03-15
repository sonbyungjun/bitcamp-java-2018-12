package com.eomcs.lms.handler;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import com.eomcs.lms.dao.PhotoBoardDao;
import com.eomcs.lms.dao.PhotoFileDao;

public class PhotoBoardDeleteCommand extends AbstractCommand {

  SqlSessionFactory sqlSessionFactory;

  public PhotoBoardDeleteCommand(SqlSessionFactory sqlSessionFactory) {
    this.sqlSessionFactory = sqlSessionFactory;
  }
  @Override
  public void execute(Response response) throws Exception {
    SqlSession sqlSession = sqlSessionFactory.openSession();
    
    try {
      
      PhotoBoardDao photoBoardDao = sqlSession.getMapper(PhotoBoardDao.class);
      PhotoFileDao photoFileDao = sqlSession.getMapper(PhotoFileDao.class);
      
      int no = response.requestInt("번호?");

      photoFileDao.deleteByPhotoBoardNo(no);

      if (photoBoardDao.delete(no) == 0) {
        response.println("해당 사진을 찾을 수 없습니다.");
        return;
      }

      response.println("사진을 삭제했습니다.");
      sqlSession.commit();

    } catch(Exception e) {
      sqlSession.rollback();
      response.println("삭제 중 오류 발생.");
    } finally {
      sqlSession.close();
    }
  }

}
