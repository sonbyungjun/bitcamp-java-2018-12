package com.eomcs.lms.handler;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import com.eomcs.lms.dao.BoardDao;
import com.eomcs.lms.domain.Board;

public class BoardDetailCommand extends AbstractCommand {

  SqlSessionFactory sqlSessionFactory;

  public BoardDetailCommand(SqlSessionFactory sqlSessionFactory) {
    this.sqlSessionFactory = sqlSessionFactory;
  }

  @Override
  public void execute(Response response) throws Exception {
    
    try (SqlSession sqlSession = sqlSessionFactory.openSession()) {

      BoardDao boardDao = sqlSession.getMapper(BoardDao.class);
      
      int no = response.requestInt("번호?");

      Board board = boardDao.findByNo(no);
      if (board == null) {
        response.println("해당 번호의 게시물이 없습니다.");
        return;
      }
     
      boardDao.increaseCount(no);
      sqlSession.commit();
      
      response.println(
          String.format("내용: %s", board.getContents()));
      response.println(
          String.format("작성일: %s", board.getCreatedDate()));
      response.println(
          String.format("조회수: %d", board.getViewCount()));
    }
  }
}
