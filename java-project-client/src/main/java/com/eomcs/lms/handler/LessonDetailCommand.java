package com.eomcs.lms.handler;
import java.util.Scanner;
import com.eomcs.lms.Dao.LessonDao;
import com.eomcs.lms.domain.Lesson;

public class LessonDetailCommand implements Command {

  Scanner keyboard;
  LessonDao lessonDao;

  public LessonDetailCommand(Scanner keyboard, LessonDao lessonDao) {
    this.keyboard = keyboard;
    this.lessonDao = lessonDao;
  }

  @Override
  public void execute() {
    System.out.print("번호? ");
    int no = Integer.parseInt(keyboard.nextLine());
    
    try {
    Lesson lesson = lessonDao.findByNo(no);
    System.out.printf("수업명: %s\n", lesson.getTitle());
    System.out.printf("설명: %s\n", lesson.getContents());
    System.out.printf("기간: %s ~ %s\n", lesson.getStartDate(), lesson.getEndDate());
    System.out.printf("총수업시간: %d\n", lesson.getTotalHours());
    System.out.printf("일수업시간: %d\n", lesson.getDayHours());
    
    } catch (Exception e) {
      System.out.printf("수업 상세 정보 출력 오류! : %s\n", e.getMessage());
    }
  }

}
