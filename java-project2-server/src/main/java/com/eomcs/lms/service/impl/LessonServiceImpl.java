package com.eomcs.lms.service.impl;

import java.util.HashMap;
import java.util.List;
import org.springframework.stereotype.Service;
import com.eomcs.lms.dao.LessonDao;
import com.eomcs.lms.dao.PhotoBoardDao;
import com.eomcs.lms.dao.PhotoFileDao;
import com.eomcs.lms.domain.Lesson;
import com.eomcs.lms.domain.PhotoBoard;
import com.eomcs.lms.service.LessonService;

@Service
public class LessonServiceImpl implements LessonService {

  LessonDao lessonDao;
  PhotoBoardDao photoBoardDao;
  PhotoFileDao photoFileDao;

  public LessonServiceImpl(
      LessonDao lessonDao, 
      PhotoBoardDao photoBoardDao,
      PhotoFileDao photoFileDao) {
    this.lessonDao = lessonDao;
    this.photoBoardDao = photoBoardDao;
    this.photoFileDao = photoFileDao;
  }

  @Override
  public List<Lesson> list() {
    return lessonDao.findAll();
  }

  @Override
  public int add(Lesson lesson) {
    return lessonDao.insert(lesson);
  }

  @Override
  public Lesson get(int no) {
    return lessonDao.findByNo(no);
  }

  @Override
  public int update(Lesson lesson) {
    return lessonDao.update(lesson);
  }

  @Override
  //@Transactional(propagation=Propagation.REQUIRED)
  public int delete(int no) {
    HashMap<String,Object> params = new HashMap<>();
    params.put("lessonNo", no);

    List<PhotoBoard> boards = photoBoardDao.findAll(params);
    for (PhotoBoard board : boards) {
      photoFileDao.deleteByPhotoBoardNo(board.getNo());
      photoBoardDao.delete(board.getNo());
    }

    return lessonDao.delete(no);
  }
}
