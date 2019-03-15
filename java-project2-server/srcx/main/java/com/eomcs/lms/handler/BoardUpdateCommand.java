package com.eomcs.lms.handler;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import com.eomcs.lms.dao.BoardDao;
import com.eomcs.lms.domain.Board;

public class BoardUpdateCommand extends AbstractCommand {

  SqlSessionFactory sqlSessionFactory;

  public BoardUpdateCommand(SqlSessionFactory sqlSessionFactory) {
    this.sqlSessionFactory = sqlSessionFactory;
  }

  @Override
  public void execute(Response response) throws Exception {

    try (SqlSession sqlSession = sqlSessionFactory.openSession()) {

      BoardDao boardDao = sqlSession.getMapper(BoardDao.class);

      Board board = new Board();

      board.setNo(response.requestInt("번호?"));

      board.setContents(response.requestString("내용?"));

      if (boardDao.update(board) == 0) {
        response.println("해당 게시물이 없습니다.");
        return;
      }
      response.println("게시글을 변경했습니다.");
      sqlSession.commit();
    }
  }

}
