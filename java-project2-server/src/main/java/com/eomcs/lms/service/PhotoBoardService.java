package com.eomcs.lms.service;

import java.util.List;
import com.eomcs.lms.domain.PhotoBoard;

public interface PhotoBoardService {
  int add(PhotoBoard photoBoard);
  List<PhotoBoard> list(int lessonNo, String searchWord);
  PhotoBoard get(int no);
  int update(PhotoBoard photoBoard);
  int delete(int no);
}
