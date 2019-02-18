package com.eomcs.lms.handler;
import java.util.Scanner;
import com.eomcs.lms.Dao.LessonDao;

public class LessonDeleteCommand implements Command {

  Scanner keyboard;
  LessonDao lessonDao;

  public LessonDeleteCommand(Scanner keyboard, LessonDao lessonDao) {
    this.keyboard = keyboard;
    this.lessonDao = lessonDao;
  }

  @Override
  public void execute() {
    System.out.print("번호? ");
    int no = Integer.parseInt(keyboard.nextLine());
    
    try {
    lessonDao.delete(no);
    System.out.println("수업을 삭제했습니다.");
    
    } catch (Exception e) {
      System.out.printf("수업 삭제 오류! : %s\n", e.getMessage());
    }
  }
  
}
