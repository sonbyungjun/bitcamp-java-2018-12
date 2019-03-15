package com.eomcs.lms.handler;
import java.sql.Date;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import com.eomcs.lms.dao.LessonDao;
import com.eomcs.lms.domain.Lesson;

public class LessonUpdateCommand extends AbstractCommand {

  SqlSessionFactory sqlSessionFactory;

  public LessonUpdateCommand(SqlSessionFactory sqlSessionFactory) {
    this.sqlSessionFactory = sqlSessionFactory;
  }

  @Override
  public void execute(Response response) throws Exception {

    try (SqlSession sqlSession = sqlSessionFactory.openSession()) {

      LessonDao lessonDao = sqlSession.getMapper(LessonDao.class);

      int no = response.requestInt("번호?");

      Lesson lesson = lessonDao.findByNo(no);
      if (lesson == null) {
        response.println("해당 수업을 찾지 못했습니다.");
        return;
      }

      Lesson temp = new Lesson();

      temp.setNo(no);

      String input = response.requestString(
          String.format("수업명(%s)?", lesson.getTitle()));
      if (input.length() > 0) 
        temp.setTitle(input);

      if ((input = response.requestString(
          String.format("설명(%s)?", lesson.getContents()))).length() > 0)
        temp.setContents(input);

      if ((input = response.requestString(
          String.format("시작일(%s)?", lesson.getStartDate()))).length() > 0)
        temp.setStartDate(Date.valueOf(input));

      if ((input = response.requestString(
          String.format("종료일(%s)?", lesson.getEndDate()))).length() > 0)
        temp.setEndDate(Date.valueOf(input));

      if ((input = response.requestString(
          String.format("총수업시간(%d)?", lesson.getTotalHours()))).length() > 0)
        temp.setTotalHours(Integer.parseInt(input));

      if ((input = response.requestString(
          String.format("일수업시간(%d)?", lesson.getDayHours()))).length() > 0)
        temp.setDayHours(Integer.parseInt(input));

      if (temp.getTitle() != null
          || temp.getContents() != null
          || temp.getStartDate() != null
          || temp.getEndDate() != null
          || temp.getTotalHours() > 0
          || temp.getDayHours() > 0) {
        lessonDao.update(temp);
        sqlSession.commit();
        response.println("수업을 변경했습니다.");
      } else {
        response.println("변경 취소했습니다.");
      }
    }
  }

}
