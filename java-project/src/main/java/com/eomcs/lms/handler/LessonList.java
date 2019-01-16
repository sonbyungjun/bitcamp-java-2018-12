package com.eomcs.lms.handler;

import com.eomcs.lms.domain.Lesson;

public class LessonList {

  private final int PRIMARYIDX = 10;
  private int idx = 0;
  private Lesson[] lessons;
  
  public LessonList() {
    this.lessons = new Lesson[PRIMARYIDX];
  }
  
  public LessonList(int index) {
    if (index > PRIMARYIDX)
      this.lessons = new Lesson[index];
  }
  
  
  public Lesson[] toArray() {
    Lesson[] b1 = this.lessons;
    Lesson[] b2 = new Lesson[this.idx];
    for (int i = 0; i < this.idx; i++) {
      b2[i] = b1[i];
    }
    return b2;
  }
  
  public void add(Lesson lesson) {
    int oldIdx = idx;
    int newIdx = oldIdx + (oldIdx * 2);
    
    if (idx >= this.lessons.length) {
      Lesson[] b1 = new Lesson[newIdx];
      
      for (int i = 0; i < idx; i++) {
        b1[i] = lessons[i];
      }
      this.lessons = b1;
    }
    
    this.lessons[this.idx] = lesson;
    this.idx++;
    
  }
}
