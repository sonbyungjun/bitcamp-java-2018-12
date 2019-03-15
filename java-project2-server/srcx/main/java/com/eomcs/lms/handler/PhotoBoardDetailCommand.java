package com.eomcs.lms.handler;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import com.eomcs.lms.dao.PhotoBoardDao;
import com.eomcs.lms.domain.PhotoBoard;
import com.eomcs.lms.domain.PhotoFile;

public class PhotoBoardDetailCommand extends AbstractCommand {

  SqlSessionFactory sqlSessionFactory;

  public PhotoBoardDetailCommand(SqlSessionFactory sqlSessionFactory) {
    this.sqlSessionFactory = sqlSessionFactory;
  }

  @Override
  public void execute(Response response) throws Exception {

    try (SqlSession sqlSession = sqlSessionFactory.openSession()) {

      PhotoBoardDao photoBoardDao = sqlSession.getMapper(PhotoBoardDao.class);

      int no = response.requestInt("번호?");

      PhotoBoard photoBoard = photoBoardDao.findByNoWithFile(no);
      
      if (photoBoard == null) {
        response.println("해당 사진을 찾을 수 없습니다.");
        return;
      }
      photoBoardDao.increaseCount(no);
      sqlSession.commit();
      
      response.println(
          String.format("제목: %s", photoBoard.getTitle()));
      response.println(
          String.format("작성일: %s", photoBoard.getCreatedDate()));
      response.println(
          String.format("조회수: %d", photoBoard.getViewCount()));
      response.println(
          String.format("수업: %s(%s ~ %s)",
              photoBoard.getLesson().getTitle(),
              photoBoard.getLesson().getStartDate(),
              photoBoard.getLesson().getEndDate()));

      response.println("사진파일:");
      for (PhotoFile file : photoBoard.getFiles()) {
        response.println(
            String.format("> %s", file.getFilePath()));
      }
    }
  }

}
