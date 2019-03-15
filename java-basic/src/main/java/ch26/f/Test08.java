package ch26.f;

import java.util.HashMap;
import java.util.Scanner;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Test08 {

  public static void main(String[] args) throws Exception {

    SqlSession sqlSession = new SqlSessionFactoryBuilder().build(
        Resources.getResourceAsStream(
            "ch26/f/mybatis-config.xml")).openSession();

    HashMap<String,Object> params = new HashMap<>();

    Scanner keyboard = new Scanner(System.in);
    System.out.print("번호? ");
    int no = Integer.parseInt(keyboard.nextLine());
    params.put("no", no);
    
    System.out.print("제목? ");
    String value = keyboard.nextLine();
    if (value.length() > 0) {
      params.put("title", value);
    }
    
    System.out.print("내용? ");
    value = keyboard.nextLine();
    if (value.length() > 0) {
      params.put("contents", value);
    }
    keyboard.close();
    
    Board board = sqlSession.selectOne("board.select1", no);
    System.out.println("[변경 전]");
    System.out.println(board);

    int count = sqlSession.update("board.update1", params);
    System.out.println(count);
    
    board = sqlSession.selectOne("board.select1", no);
    System.out.println("[변경 후]");
    System.out.println(board);

  }
}
