package ch26.f;

import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Test02 {

  public static void main(String[] args) throws Exception {

    SqlSession sqlSession = new SqlSessionFactoryBuilder().build(
        Resources.getResourceAsStream(
            "ch26/f/mybatis-config.xml")).openSession();

    Scanner keyboard = new Scanner(System.in);
    System.out.print("게시물번호? ");
    String value = keyboard.nextLine();
    keyboard.close();

    HashMap<String,Object> params = new HashMap<>();

    try {
      params.put("no", Integer.parseInt(value));
    } catch (Exception e) {}

    List<Board> boards = sqlSession.selectList("board.select2", params);

    for (Board b : boards) {
      System.out.println(b);
    }
    System.out.println("----------------------------------------------");

  }
}
