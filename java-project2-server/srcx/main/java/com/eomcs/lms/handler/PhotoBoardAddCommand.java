package com.eomcs.lms.handler;
import java.util.ArrayList;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import com.eomcs.lms.dao.PhotoBoardDao;
import com.eomcs.lms.dao.PhotoFileDao;
import com.eomcs.lms.domain.PhotoBoard;
import com.eomcs.lms.domain.PhotoFile;

public class PhotoBoardAddCommand extends AbstractCommand {

  SqlSessionFactory sqlSessionFactory;

  public PhotoBoardAddCommand(SqlSessionFactory sqlSessionFactory) {
    this.sqlSessionFactory = sqlSessionFactory;
  }
  
  @Override
  public void execute(Response response) throws Exception {
    
    SqlSession sqlSession = sqlSessionFactory.openSession();
    
    try {

      PhotoBoardDao photoBoardDao = sqlSession.getMapper(PhotoBoardDao.class);
      PhotoFileDao photoFileDao = sqlSession.getMapper(PhotoFileDao.class);

      PhotoBoard photoboard = new PhotoBoard();
      photoboard.setTitle(response.requestString("사진 제목?"));
      photoboard.setLessonNo(response.requestInt("수업?"));
      photoBoardDao.insert(photoboard);

      response.println("최소 한 개의 사진 파일을 등록해야 합니다.");
      response.println("파일명 입력 없이 그냥 엔터를 치면 파일 추가를 마칩니다.");

      ArrayList<PhotoFile> files = new ArrayList<>();
      while (true) {
        String filePath = response.requestString("사진 파일?");
        if (filePath.length() == 0) {
          if (files.size() == 0) {
            response.println("최소 한 개의 사진 파일을 등록해야 합니다.");
            continue;
          } else {
            break;
          }
        }
        PhotoFile file = new PhotoFile();
        file.setFilePath(filePath);
        file.setPhotoBoardNo(photoboard.getNo());
        files.add(file);

      }
      photoFileDao.insert(files);
      response.println("사진을 저장하였습니다.");
      sqlSession.commit();

    } catch(Exception e) {
      response.println("저장 중 오류가 발생했습니다.");
      sqlSession.rollback();
      e.printStackTrace();
    } finally {
      sqlSession.close();
    }

  }
}
