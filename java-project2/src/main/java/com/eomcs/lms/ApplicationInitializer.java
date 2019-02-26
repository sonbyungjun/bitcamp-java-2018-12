package com.eomcs.lms;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Map;
import java.util.Scanner;
import com.eomcs.lms.context.ApplicationContextException;
import com.eomcs.lms.context.ApplicationContextListener;
import com.eomcs.lms.dao.mariadb.BoardDaoImpl;
import com.eomcs.lms.dao.mariadb.LessonDaoImpl;
import com.eomcs.lms.dao.mariadb.MemberDaoImpl;
import com.eomcs.lms.handler.BoardAddCommand;
import com.eomcs.lms.handler.BoardDeleteCommand;
import com.eomcs.lms.handler.BoardDetailCommand;
import com.eomcs.lms.handler.BoardListCommand;
import com.eomcs.lms.handler.BoardUpdateCommand;
import com.eomcs.lms.handler.LessonAddCommand;
import com.eomcs.lms.handler.LessonDeleteCommand;
import com.eomcs.lms.handler.LessonDetailCommand;
import com.eomcs.lms.handler.LessonListCommand;
import com.eomcs.lms.handler.LessonUpdateCommand;
import com.eomcs.lms.handler.MemberAddCommand;
import com.eomcs.lms.handler.MemberDeleteCommand;
import com.eomcs.lms.handler.MemberDetailCommand;
import com.eomcs.lms.handler.MemberListCommand;
import com.eomcs.lms.handler.MemberUpdateCommand;

public class ApplicationInitializer implements ApplicationContextListener {
  
  Connection con;

  @Override
  public void contextInitialized(Map<String, Object> context) {
    
    try {
      con = DriverManager.getConnection(
          "jdbc:mariadb://localhost/bitcampdb?user=bitcamp&password=1111");

      LessonDaoImpl lessonDao = new LessonDaoImpl(con);
      MemberDaoImpl memberDao = new MemberDaoImpl(con);
      BoardDaoImpl boardDao = new BoardDaoImpl(con);
      
      Scanner keyboard = (Scanner) context.get("keyboard");
      
      context.put("/lesson/add", new LessonAddCommand(keyboard, lessonDao));
      context.put("/lesson/list", new LessonListCommand(keyboard, lessonDao));
      context.put("/lesson/detail", new LessonDetailCommand(keyboard, lessonDao));
      context.put("/lesson/update", new LessonUpdateCommand(keyboard, lessonDao));
      context.put("/lesson/delete", new LessonDeleteCommand(keyboard, lessonDao));

      context.put("/member/add", new MemberAddCommand(keyboard, memberDao));
      context.put("/member/list", new MemberListCommand(keyboard, memberDao));
      context.put("/member/detail", new MemberDetailCommand(keyboard, memberDao));
      context.put("/member/update", new MemberUpdateCommand(keyboard, memberDao));
      context.put("/member/delete", new MemberDeleteCommand(keyboard, memberDao));

      context.put("/board/add", new BoardAddCommand(keyboard, boardDao));
      context.put("/board/list", new BoardListCommand(keyboard, boardDao));
      context.put("/board/detail", new BoardDetailCommand(keyboard, boardDao));
      context.put("/board/update", new BoardUpdateCommand(keyboard, boardDao));
      context.put("/board/delete", new BoardDeleteCommand(keyboard, boardDao));

    } catch (Exception e) {
      throw new ApplicationContextException(e);
    }
  }

  @Override
  public void contextDestroyed(Map<String, Object> context) {
    try {
      con.close();
    } catch (SQLException e) {
      throw new ApplicationContextException(e);
    }

  }

}
