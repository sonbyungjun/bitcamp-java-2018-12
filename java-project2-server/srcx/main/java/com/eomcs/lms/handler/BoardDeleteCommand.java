package com.eomcs.lms.handler;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import com.eomcs.lms.dao.BoardDao;

public class BoardDeleteCommand extends AbstractCommand {

  SqlSessionFactory sqlSessionFactory;

  public BoardDeleteCommand(SqlSessionFactory sqlSessionFactory) {
    this.sqlSessionFactory = sqlSessionFactory;
  }

  @Override
  public void execute(Response response) throws Exception {

    try (SqlSession sqlSession = sqlSessionFactory.openSession()) {

      BoardDao boardDao = sqlSession.getMapper(BoardDao.class);

      int no = response.requestInt("번호?");

      if (boardDao.delete(no) == 0) {
        response.println("해당 번호의 게시물이 없습니다.");
        return;
      }
      sqlSession.commit();
      response.println("게시글을 삭제했습니다.");
    }
  }

}
