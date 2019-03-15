package com.eomcs.lms.dao;

import java.util.List;
import java.util.Map;
import com.eomcs.lms.domain.PhotoBoard;

public interface PhotoBoardDao {
  int insert(PhotoBoard photoboard);
  List<PhotoBoard> findAll(Map<String, Object> params);
  PhotoBoard findByNo(int no);
  int update(PhotoBoard photoboard);
  int delete(int no);
  PhotoBoard findByNoWithFile(int no);
  int increaseCount(int no);
}
