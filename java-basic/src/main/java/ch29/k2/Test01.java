package ch29.k2;

import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ch29.k2.dao.BoardDao;
import ch29.k2.vo.Board;

public class Test01 {
  public static void main(String[] args) {
    ApplicationContext iocContainer = 
        new ClassPathXmlApplicationContext("ch29/k2/application-context.xml", "ch29/k2/datasource-context.xml", "ch29/k2/mybatis-context.xml");
    
    System.out.println("------------------------------------------");
    
    String[] names = iocContainer.getBeanDefinitionNames();
    for (String name : names) {
      System.out.printf("%s ==> %s\n" , name, iocContainer.getBean(name).getClass().getName());
    }
    
    System.out.println("------------------------------------------");
    
    BoardDao boardDao = (BoardDao) iocContainer.getBean("boardDao");
    List<Board> list = boardDao.findAll();
    for (Board b : list) {
      System.out.println(b);
    }
    /*
    System.out.println("------------------------------------------");
    
    Board board = new Board();
    board.setTitle("제목입니다.");
    board.setContents("내용입니다.");
    boardDao.insert(board);
    System.out.println("입력완료!");
    
    System.out.println("------------------------------------------");
    
    boardDao = (BoardDao) iocContainer.getBean("boardDao");
    list = boardDao.findAll();
    for (Board b : list) {
      System.out.println(b);
    }
    
    System.out.println("------------------------------------------");
    
    board = boardDao.findByNo(8);
    System.out.println(board);
    
    System.out.println("------------------------------------------");
    
    board.setTitle("오호라..변경");
    boardDao.update(board);
    System.out.println("변경완료");
    
    System.out.println("------------------------------------------");
    
    board = boardDao.findByNo(8);
    System.out.println(board);
    
    System.out.println("------------------------------------------");
    
    boardDao.delete(8);
    System.out.println("삭제완료");
    
    System.out.println("------------------------------------------");
    
    boardDao = (BoardDao) iocContainer.getBean("boardDao");
    list = boardDao.findAll();
    for (Board b : list) {
      System.out.println(b);
    }
    */
  }
}
