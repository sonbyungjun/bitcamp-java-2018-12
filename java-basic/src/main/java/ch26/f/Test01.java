package ch26.f;

import java.util.List;
import java.util.Scanner;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Test01 {

  public static void main(String[] args) throws Exception {

    SqlSession sqlSession = new SqlSessionFactoryBuilder().build(
        Resources.getResourceAsStream(
            "ch26/f/mybatis-config.xml")).openSession();

    Scanner keyboard = new Scanner(System.in);
    System.out.print("게시물번호? ");
    String keyword = keyboard.nextLine();
    keyboard.close();

    List<Board> boards = null;

    try {
      boards = sqlSession.selectList("board.select1", Integer.parseInt(keyword));
    } catch (Exception e) {
      boards = sqlSession.selectList("board.select1");
    }

    for (Board b : boards) {
      System.out.println(b);
    }
    System.out.println("----------------------------------------------");

  }
}
