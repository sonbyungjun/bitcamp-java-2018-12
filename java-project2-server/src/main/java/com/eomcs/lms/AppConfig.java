package com.eomcs.lms;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import com.eomcs.lms.context.Bean;
import com.eomcs.lms.context.ComponentScan;
import com.eomcs.lms.dao.BoardDao;
import com.eomcs.lms.dao.LessonDao;
import com.eomcs.lms.dao.MemberDao;
import com.eomcs.lms.dao.PhotoBoardDao;
import com.eomcs.lms.dao.PhotoFileDao;
import com.eomcs.mybatis.DaoFactory;
import com.eomcs.mybatis.SqlSessionFactoryProxy;
import com.eomcs.mybatis.TransactionManager;

@ComponentScan(basePackages="com.eomcs.lms")
public class AppConfig {

  @Bean
  public BoardDao boardDao(DaoFactory daoFactory) {
    return daoFactory.create(BoardDao.class);
  }
  
  @Bean
  public MemberDao memberDao(DaoFactory daoFactory) {
    return daoFactory.create(MemberDao.class);
  }
  
  @Bean
  public LessonDao lessonDao(DaoFactory daoFactory) {
    return daoFactory.create(LessonDao.class);
  }
  
  @Bean
  public PhotoBoardDao photoBoardDao(DaoFactory daoFactory) {
    return daoFactory.create(PhotoBoardDao.class);
  }
  
  @Bean
  public PhotoFileDao photoFileDao(DaoFactory daoFactory) {
    return daoFactory.create(PhotoFileDao.class);
  }
  
  @Bean
  public SqlSessionFactoryProxy sqlSessionFactoryProxy() throws Exception {
    return new SqlSessionFactoryProxy(
        new SqlSessionFactoryBuilder().build(
            Resources.getResourceAsStream("com/eomcs/lms/conf/mybatis-config.xml")));
  }

  @Bean
  public TransactionManager transactionManager(SqlSessionFactoryProxy sqlSessionFactoryProxy) {
    return new TransactionManager(sqlSessionFactoryProxy);
  }

  @Bean
  public DaoFactory daoFactory(SqlSessionFactoryProxy sqlSessionFactoryProxy) {
    // DAO 인터페이스의 구현체를 자동으로 생성하기
    return new DaoFactory(sqlSessionFactoryProxy);
  }
  
  
}
