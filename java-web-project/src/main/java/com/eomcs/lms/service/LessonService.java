package com.eomcs.lms.service;

import java.util.List;
import com.eomcs.lms.domain.Lesson;

public interface LessonService {
  int add(Lesson lesson);
  List<Lesson> list(int pageNo, int pageSize);
  Lesson get(int no);
  int update(Lesson lesson);
  int delete(int no);
  int size();
}
