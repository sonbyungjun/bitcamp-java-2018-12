package com.eomcs.lms.handler;
import java.util.Scanner;
import com.eomcs.lms.dao.LessonDao;

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
      if (lessonDao.delete(no) == 0) {
        System.out.println("해당 수업을 찾지 못했습니다.");
        return;
      }
      System.out.println("수업을 삭제했습니다.");

    } catch (Exception e) {
      System.out.printf("수업 삭제 오류! : %s\n", e.getMessage());
    }
  }

}
