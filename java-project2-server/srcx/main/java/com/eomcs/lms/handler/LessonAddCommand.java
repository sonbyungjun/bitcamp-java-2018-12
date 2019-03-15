package com.eomcs.lms.handler;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import com.eomcs.lms.dao.LessonDao;
import com.eomcs.lms.domain.Lesson;

public class LessonAddCommand extends AbstractCommand {

  SqlSessionFactory sqlSessionFactory;

  public LessonAddCommand(SqlSessionFactory sqlSessionFactory) {
    this.sqlSessionFactory = sqlSessionFactory;
  }

  @Override
  public void execute(Response response) throws Exception {

    try (SqlSession sqlSession = sqlSessionFactory.openSession()) {

      LessonDao lessonDao = sqlSession.getMapper(LessonDao.class);

      Lesson lesson = new Lesson();
      lesson.setTitle(response.requestString("수업명?"));
      lesson.setContents(response.requestString("설명?"));
      lesson.setStartDate(response.requestDate("시작일?"));
      lesson.setEndDate(response.requestDate("종료일?"));
      lesson.setTotalHours(response.requestInt("총수업시간?"));
      lesson.setDayHours(response.requestInt("일수업시간?"));

      lessonDao.insert(lesson);
      response.println("저장하였습니다.");
      sqlSession.commit();
    }
  }
}
