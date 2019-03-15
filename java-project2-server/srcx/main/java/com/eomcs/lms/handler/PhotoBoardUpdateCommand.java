package com.eomcs.lms.handler;
import java.util.ArrayList;
import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import com.eomcs.lms.dao.PhotoBoardDao;
import com.eomcs.lms.dao.PhotoFileDao;
import com.eomcs.lms.domain.PhotoBoard;
import com.eomcs.lms.domain.PhotoFile;

public class PhotoBoardUpdateCommand extends AbstractCommand {

  SqlSessionFactory sqlSessionFactory;

  public PhotoBoardUpdateCommand(SqlSessionFactory sqlSessionFactory) {
    this.sqlSessionFactory = sqlSessionFactory;
  }

  @Override
  public void execute(Response response) throws Exception {
    SqlSession sqlSession = sqlSessionFactory.openSession();

    try {

      PhotoBoardDao photoBoardDao = sqlSession.getMapper(PhotoBoardDao.class);
      PhotoFileDao photoFileDao = sqlSession.getMapper(PhotoFileDao.class);
      
      int no = response.requestInt("번호?");

      PhotoBoard photoBoard = photoBoardDao.findByNo(no);
      if (photoBoard == null) {
        response.println("해당 사진을 찾을 수 없습니다.");
        return;
      }

      @SuppressWarnings("null")
      String input = response.requestString(
          String.format("제목(%s)?", photoBoard.getTitle()));

      if (input.length() > 0) {
        photoBoard.setTitle(input);
        photoBoardDao.update(photoBoard);
      }

      response.println("사진 파일:");
      List<PhotoFile> files = photoFileDao.findByPhotoBoardNo(no);
      for (PhotoFile file : files) {
        response.println("> " + file.getFilePath());
      }
      response.println("");

      response.println("사진은 일부만 변경할 수 없습니다.");
      response.println("전체를 새로 등록해야 합니다.");
      input = response.requestString("사진을 변경하시겠습니까?(y/N)");

      if (input.equalsIgnoreCase("y")) {

        photoFileDao.deleteByPhotoBoardNo(photoBoard.getNo());

        response.println("최소 한 개의 사진 파일을 등록해야 합니다.");
        response.println("파일명 입력 없이 그냥 엔터를 치면 파일 추가를 마칩니다.");

        ArrayList<PhotoFile> photoFiles = new ArrayList<>();
        while (true) {
          String filePath = response.requestString("사진 파일?");
          if (filePath.length() == 0) {
            if (photoFiles.size() == 0) {
              response.println("최소 한 개의 사진 파일을 등록해야 합니다.");
              continue;
            } else {
              break;
            }
          }
          PhotoFile file = new PhotoFile();
          file.setFilePath(filePath);
          file.setPhotoBoardNo(photoBoard.getNo());
          photoFiles.add(file);
        } // while

        photoFileDao.insert(photoFiles);
      }
      response.println("변경했습니다.");
      sqlSession.commit();

    } catch(Exception e) {
      sqlSession.rollback();
      response.println("변경 중 오류 발생.");
    } finally {
      sqlSession.close();
    }
  }

}
