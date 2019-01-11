package com.eomcs.lms;

import java.sql.Date;
import java.util.Scanner;

public class Lesson {
  
  int no;
  String title;
  String contents;
  Date startDate;
  Date endDate;
  int totalHours;
  int dayHours;
  
  static Scanner keyboard = new Scanner(System.in);
  
  static Lesson addLesson() {
    
    Lesson lesson = new Lesson();

    System.out.print("번호? ");
    lesson.no = Integer.parseInt(keyboard.nextLine());

    System.out.print("수업명? ");
    lesson.title = keyboard.nextLine();

    System.out.print("설명? ");
    lesson.contents = keyboard.nextLine();

    System.out.print("시작일? ");
    lesson.startDate = Date.valueOf(keyboard.nextLine());

    System.out.print("종료일? ");
    lesson.endDate = Date.valueOf(keyboard.nextLine());

    System.out.print("총수업시간? ");
    lesson.totalHours = Integer.parseInt(keyboard.nextLine());

    System.out.print("일수업시간? ");
    lesson.dayHours = Integer.parseInt(keyboard.nextLine());

    return lesson;
  }
  
  static void listLesson() {
    for (int j = 0; j < App.lessonIdx; j++) {
      System.out.printf("%3d, %-15s, %10s ~ %10s, %4d\n", 
          App.lessons[j].no, App.lessons[j].title, App.lessons[j].startDate, 
          App.lessons[j].endDate, App.lessons[j].totalHours);
    }
  }
  
}
