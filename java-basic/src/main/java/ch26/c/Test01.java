package ch26.c;

import java.io.InputStream;
import java.util.List;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Test01 {

  public static void main(String[] args) throws Exception {

    String resource = "ch26/c/mybatis-config.xml";
    InputStream inputStream = Resources.getResourceAsStream(resource);
    SqlSessionFactory sqlSessionFactory =
        new SqlSessionFactoryBuilder().build(inputStream);
    
    SqlSession sqlSession = sqlSessionFactory.openSession();
    
    List<Board> list = sqlSession.selectList("board.select1");
    
    for (Board b : list) {
      System.out.printf("%d, %s, %s, %s, %d\n",
          b.getBoard_id(),
          b.getTitle(),
          b.getContents(),
          b.getCreated_date(),
          b.getView_count());
    }
  }

}
