package com.eomcs.lms.handler;
import java.sql.Date;
import java.util.Scanner;
import com.eomcs.lms.domain.Lesson;
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
    int no = promptLessonNo();
    int i = indexOfBoard(no);
    if (!validate(i))
      return;
    Lesson lesson = list.get(i);
    System.out.printf("수업명: %s\n", lesson.getTitle());
    System.out.printf("수업내용: %s\n", lesson.getContents());
    System.out.printf("기간: %s ~ %s\n", lesson.getStartDate(), lesson.getEndDate());
    System.out.printf("총수업시간: %s\n", lesson.getTotalHours());
    System.out.printf("일수업시간: %s\n", lesson.getDayHours());
  }

  public void updateBoard() {
    int no = promptLessonNo();
    int i = indexOfBoard(no);
    if (!validate(i))
      return;
    Lesson lesson = list.get(i);
    
    Lesson temp = new Lesson();
    temp.setNo(lesson.getNo());
    System.out.printf("수업명(%s)? ", lesson.getTitle());
    String cmd = keyboard.nextLine();
    temp.setTitle(cmd.length() > 0 ? cmd : lesson.getTitle());

    System.out.print("수업내용? ");
    cmd = keyboard.nextLine();
    temp.setContents(cmd.length() > 0 ? cmd : lesson.getContents());

    System.out.printf("시작일(%s)? ", lesson.getStartDate());
    cmd = keyboard.nextLine();
    temp.setStartDate(cmd.length() > 0 ? Date.valueOf(cmd) : lesson.getStartDate());

    System.out.printf("종료일(%s)? ", lesson.getEndDate());
    cmd = keyboard.nextLine();
    temp.setEndDate(cmd.length() > 0 ? Date.valueOf(cmd) : lesson.getEndDate());

    System.out.printf("총수업시간(%s)? ", lesson.getTotalHours());
    cmd = keyboard.nextLine();
    temp.setTotalHours(cmd.length() > 0 ? Integer.parseInt(cmd) : lesson.getTotalHours());

    System.out.printf("일수업시간(%s)? ", lesson.getDayHours());
    cmd = keyboard.nextLine();
    temp.setDayHours(cmd.length() > 0 ? Integer.parseInt(cmd) : lesson.getDayHours());

    list.set(i, temp);
    System.out.println("수업을 변경했습니다.");
  }

  public void deleteBoard() {
    int no = promptLessonNo();
    int i = indexOfBoard(no);
    if (!validate(i))
      return;
    list.remove(i);
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
  
  private int promptLessonNo() {
    System.out.print("번호? ");
    return Integer.parseInt(keyboard.nextLine());
  }
  
  private boolean validate(int index) {
    if (index == -1) {
      System.out.println("해당 수업을 찾을 수 없습니다.");
      return false;
    }
    return true;
  }
}
