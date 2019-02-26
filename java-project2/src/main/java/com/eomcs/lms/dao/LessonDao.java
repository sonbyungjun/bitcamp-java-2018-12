package com.eomcs.lms.dao;

import java.util.List;
import com.eomcs.lms.domain.Lesson;

public interface LessonDao {
  public void insert(Lesson lesson);
  public List<Lesson> findAll();
  public Lesson findByNo(int no);
  public int update(Lesson lesson);
  public int delete(int no);
}
