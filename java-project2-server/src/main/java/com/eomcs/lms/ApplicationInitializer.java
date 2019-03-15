package com.eomcs.lms;

import java.util.HashMap;
import java.util.Map;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import com.eomcs.lms.context.ApplicationContext;
import com.eomcs.lms.context.ApplicationContextException;
import com.eomcs.lms.context.ApplicationContextListener;
import com.eomcs.lms.dao.BoardDao;
import com.eomcs.lms.dao.LessonDao;
import com.eomcs.lms.dao.MemberDao;
import com.eomcs.lms.dao.PhotoBoardDao;
import com.eomcs.lms.dao.PhotoFileDao;
import com.eomcs.mybatis.DaoFactory;
import com.eomcs.mybatis.SqlSessionFactoryProxy;
import com.eomcs.mybatis.TransactionManager;

// App 객체의 상태가 변경될 때 마다 보고 받는 옵저버가 되려면 
// ApplicationContextListener 규격에 따라 작성해야 한다.
public class ApplicationInitializer implements ApplicationContextListener {

  @Override
  public void contextInitialized(Map<String, Object> context) {
    try {
      // Mybatis의 SqlSessionFactory 준비
      SqlSessionFactory sqlSessionFactory =
        new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream(
            "com/eomcs/lms/conf/mybatis-config.xml"));
      
      // SqlSessionFactory 구현체의 프록시를 만든다.
      SqlSessionFactoryProxy sqlSessionFactoryProxy = 
          new SqlSessionFactoryProxy(sqlSessionFactory);
      
      // 트랜잭션 매지저 준비
      TransactionManager txManager = new TransactionManager(sqlSessionFactoryProxy);
      
      // DAO 인터페이스의 구현체를 자동으로 생성하기
      DaoFactory daoFactory = new DaoFactory(sqlSessionFactoryProxy);
      
      BoardDao boardDao = daoFactory.create(BoardDao.class);
      LessonDao lessonDao = daoFactory.create(LessonDao.class);
      MemberDao memberDao = daoFactory.create(MemberDao.class);
      PhotoBoardDao photoBoardDao = daoFactory.create(PhotoBoardDao.class);
      PhotoFileDao photoFileDao = daoFactory.create(PhotoFileDao.class);
      
      HashMap<String, Object> beans = new HashMap<>();
      beans.put("boardDao", boardDao);
      beans.put("lessonDao", lessonDao);
      beans.put("memberDao", memberDao);
      beans.put("photoBoardDao", photoBoardDao);
      beans.put("photoFileDao", photoFileDao);
      beans.put("txManager", txManager);
      
      ApplicationContext appCtx = new ApplicationContext("com.eomcs.lms", beans);
      
      context.put("applicationContext", appCtx);
      
    } catch (Exception e) {
      throw new ApplicationContextException(e);
    }
  }

  @Override
  public void contextDestroyed(Map<String, Object> context) {
  }
}






