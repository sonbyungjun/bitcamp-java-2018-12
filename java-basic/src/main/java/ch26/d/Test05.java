package ch26.d;

import java.util.List;
import java.util.Map;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Test05 {

  public static void main(String[] args) throws Exception {

    SqlSessionFactory sqlSessionFactory =
        new SqlSessionFactoryBuilder().build(
            Resources.getResourceAsStream(
                "ch26/d/mybatis-config.xml"));
    
    SqlSession sqlSession = sqlSessionFactory.openSession();
    
    Map<?,?> map = sqlSession.selectOne("board.select6");
    System.out.println(map);
    System.out.println(map.get("board_id"));
    System.out.println(map.get("title"));
    System.out.println(map.get("contents"));
    System.out.println(map.get("created_date"));
    System.out.println(map.get("view_count"));
    System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
    
    List<Map<?,?>> list = sqlSession.selectList("board.select7");
    for (Map<?,?> m : list) {
      System.out.println(m);
    }
  }

}
