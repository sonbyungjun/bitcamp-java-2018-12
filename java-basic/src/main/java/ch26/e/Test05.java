package ch26.e;

import java.util.List;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Test05 {

  public static void main(String[] args) throws Exception {

    SqlSessionFactory sqlSessionFactory =
        new SqlSessionFactoryBuilder().build(
            Resources.getResourceAsStream(
                "ch26/e/mybatis-config.xml"));
    
    SqlSession sqlSession = sqlSessionFactory.openSession();
    
    Board board = new Board();
    board.setTitle("오호라...제목이오!");
    board.setContents("내용이라네요...");
    sqlSession.insert("board.insert1", board);
    System.out.println(board);
    System.out.println("****************************************************************");
    
    sqlSession.insert("board.insert3", board);
    System.out.println(board);
    System.out.println("****************************************************************");
    
    List<Board> boards = sqlSession.selectList("board.select1");
    for (Board b : boards) {
      System.out.println(b);
    }
    System.out.println("----------------------------------------------");
    
    }
  }


