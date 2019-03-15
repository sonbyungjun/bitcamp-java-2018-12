package com.eomcs.lms;

import java.util.Map;
import com.eomcs.lms.context.ApplicationContext;
import com.eomcs.lms.context.ApplicationContextException;
import com.eomcs.lms.context.ApplicationContextListener;

// App 객체의 상태가 변경될 때 마다 보고 받는 옵저버가 되려면 
// ApplicationContextListener 규격에 따라 작성해야 한다.
public class ApplicationInitializer implements ApplicationContextListener {

  @Override
  public void contextInitialized(Map<String, Object> context) {
    try {
      
//      BoardDao boardDao = daoFactory.create(BoardDao.class);
//      LessonDao lessonDao = daoFactory.create(LessonDao.class);
//      MemberDao memberDao = daoFactory.create(MemberDao.class);
//      PhotoBoardDao photoBoardDao = daoFactory.create(PhotoBoardDao.class);
//      PhotoFileDao photoFileDao = daoFactory.create(PhotoFileDao.class);
//      
//      HashMap<String, Object> beans = new HashMap<>();
//      beans.put("boardDao", boardDao);
//      beans.put("lessonDao", lessonDao);
//      beans.put("memberDao", memberDao);
//      beans.put("photoBoardDao", photoBoardDao);
//      beans.put("photoFileDao", photoFileDao);
//      beans.put("txManager", txManager);
//      
      ApplicationContext appCtx = new ApplicationContext(AppConfig.class);
      
      context.put("applicationContext", appCtx);
      
    } catch (Exception e) {
      throw new ApplicationContextException(e);
    }
  }

  @Override
  public void contextDestroyed(Map<String, Object> context) {
  }
}






