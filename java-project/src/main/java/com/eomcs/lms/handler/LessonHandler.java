package com.eomcs.lms.handler;
import java.sql.Date;
import java.util.Scanner;
import com.eomcs.lms.domain.Lesson;
import com.eomcs.lms.domain.Member;
import com.eomcs.util.ArrayList;

public class LessonHandler {

  Scanner keyboard;
  ArrayList<Lesson> list;

  public LessonHandler(Scanner keyboard) {
    this.keyboard = keyboard;
    this.list = new ArrayList<>(20);
  }

  public void listLesson() {
    Lesson[] lessons = list.toArray(new Lesson[] {});
    for (Lesson lesson : lessons) {
      System.out.printf("%3d, %-15s, %10s ~ %10s, %4d\n", 
          lesson.getNo(), lesson.getTitle(), 
          lesson.getStartDate(), lesson.getEndDate(), lesson.getTotalHours());
    }
  }

  public void addLesson() {
    Lesson lesson = new Lesson();

    System.out.print("번호? ");
    lesson.setNo(Integer.parseInt(keyboard.nextLine()));

    System.out.print("수업명? ");
    lesson.setTitle(keyboard.nextLine());

    System.out.print("설명? ");
    lesson.setContents(keyboard.nextLine());

    System.out.print("시작일? ");
    lesson.setStartDate(Date.valueOf(keyboard.nextLine()));

    System.out.print("종료일? ");
    lesson.setEndDate(Date.valueOf(keyboard.nextLine()));

    System.out.print("총수업시간? ");
    lesson.setTotalHours(Integer.parseInt(keyboard.nextLine()));

    System.out.print("일수업시간? ");
    lesson.setDayHours(Integer.parseInt(keyboard.nextLine()));

    list.add(lesson);

    System.out.println("저장하였습니다.");
  }
  
  public void datailBoard() {
    System.out.print("번호? ");
    int no = Integer.parseInt(keyboard.nextLine());
    int i = indexOfBoard(no);
    Lesson lesson = list.get(i);
    if (i == -1) {
      System.out.println("해당 수업을 찾을 수 없습니다.");
      return;
    }
    System.out.printf("수업명: %s\n", lesson.getTitle());
    System.out.printf("설명: %s\n", lesson.getContents());
    System.out.printf("시작일: %s\n", lesson.getStartDate());
    System.out.printf("종료일: %s\n", lesson.getEndDate());
    System.out.printf("총수업시간: %s\n", lesson.getTotalHours());
    System.out.printf("일수업시간: %s\n", lesson.getDayHours());
  }

  public void updateBoard() {
    System.out.print("번호? ");
    int no = Integer.parseInt(keyboard.nextLine());
    int i = indexOfBoard(no);
    Lesson lesson = list.get(i);
    if (i == -1) {
      System.out.println("해당 수업을 찾을 수 없습니다.");
      return;
    }

    System.out.printf("수업명(%s)? ", lesson.getTitle());
    String cmd = keyboard.nextLine();
    if (cmd.length() > 0)
      lesson.setTitle(cmd);

    System.out.print("수업내용? ");
    if ((cmd = keyboard.nextLine()).length() > 0)
      lesson.setContents(cmd);

    System.out.printf("시작일(%s)? ", lesson.getStartDate());
    if ((cmd = keyboard.nextLine()).length() > 0)
      lesson.setStartDate(Date.valueOf(cmd));

    System.out.printf("종료일(%s)? ", lesson.getEndDate());
    if ((cmd = keyboard.nextLine()).length() > 0)
      lesson.setEndDate(Date.valueOf(cmd));

    System.out.printf("총수업시간(%s)? ", lesson.getTotalHours());
    if ((cmd = keyboard.nextLine()).length() > 0)
      lesson.setTotalHours(Integer.parseInt(cmd));
    
    System.out.printf("일수업시간(%s)? ", lesson.getDayHours());
    if ((cmd = keyboard.nextLine()).length() > 0)
      lesson.setDayHours(Integer.parseInt(cmd));
    

    list.set(i, lesson);
    System.out.println("수업을 변경했습니다.");
  }

  public void deleteBoard() {
    System.out.print("번호? ");
    int no = Integer.parseInt(keyboard.nextLine());
    int i = indexOfBoard(no);
    if (i == -1) {
      System.out.println("해당 수업을 찾을 수 없습니다.");
      return;
    }
    list.delete(i);
    System.out.println("수업을 삭제했습니다.");
  }


  private int indexOfBoard(int index) {
    for (int i = 0; i < list.getSize(); i++) {
      Lesson lesson = list.get(i);
      if (lesson.getNo() == index)
        return i;
    }
    return -1;
  }
}
