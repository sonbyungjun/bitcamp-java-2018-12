package ch26.g;

import java.util.Scanner;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Test01 {

  public static void main(String[] args) throws Exception {

    SqlSession sqlSession = new SqlSessionFactoryBuilder().build(
        Resources.getResourceAsStream(
            "ch26/g/mybatis-config.xml")).openSession();

    Scanner keyboard = new Scanner(System.in);
    System.out.print("게시물번호? ");
    String keyword = keyboard.nextLine();
    keyboard.close();

    Board board = sqlSession.selectOne("board.select1", Integer.parseInt(keyword));
    System.out.println(board);
  }
}
