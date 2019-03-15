package ch26.h;

import java.util.List;
import java.util.Scanner;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Test01 {

  public static void main(String[] args) throws Exception {

    SqlSession sqlSession = new SqlSessionFactoryBuilder().build(
        Resources.getResourceAsStream(
            "ch26/h/mybatis-config.xml")).openSession();

    Scanner keyboard = new Scanner(System.in);
    System.out.print("게시물번호? ");
    int no = Integer.parseInt(keyboard.nextLine());
    keyboard.close();

    Board board = sqlSession.selectOne("board.selectBoard", no);
    System.out.println(board);
    
    List<AttachFile> files = sqlSession.selectList("board.selectAttachFile", no);
    System.out.println("[첨부파일]");
    for (AttachFile a : files) {
      System.out.println("  => " + a);
    }
    System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
    
  }
}
