package ch26.f;

import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Test04 {

  public static void main(String[] args) throws Exception {

    SqlSession sqlSession = new SqlSessionFactoryBuilder().build(
        Resources.getResourceAsStream(
            "ch26/f/mybatis-config.xml")).openSession();

    HashMap<String,Object> params = new HashMap<>();

    Scanner keyboard = new Scanner(System.in);
    System.out.print("게시물번호? ");
    String value = keyboard.nextLine();
    
    try {
      params.put("no", Integer.parseInt(value));
    } catch (Exception e) {
    }
    
    System.out.print("제목? ");
    value = keyboard.nextLine();
    if (value.length() > 0) {
      params.put("title", value);
    }
    
    System.out.print("내용? ");
    value = keyboard.nextLine();
    if (value.length() > 0) {
      params.put("contents", value);
    }

    keyboard.close();

    List<Board> boards = sqlSession.selectList("board.select4", params);

    for (Board b : boards) {
      System.out.println(b);
    }
    System.out.println("----------------------------------------------");

  }
}
