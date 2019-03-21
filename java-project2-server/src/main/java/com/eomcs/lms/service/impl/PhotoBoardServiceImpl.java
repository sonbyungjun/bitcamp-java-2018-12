package com.eomcs.lms.service.impl;

import java.util.HashMap;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import com.eomcs.lms.dao.PhotoBoardDao;
import com.eomcs.lms.dao.PhotoFileDao;
import com.eomcs.lms.domain.PhotoBoard;
import com.eomcs.lms.domain.PhotoFile;
import com.eomcs.lms.service.PhotoBoardService;

@Service
public class PhotoBoardServiceImpl implements PhotoBoardService {

  PlatformTransactionManager txManager;
  PhotoBoardDao boardDao;
  PhotoFileDao fileDao;

  public PhotoBoardServiceImpl(PhotoBoardDao boardDao, PhotoFileDao fileDao, PlatformTransactionManager txManager) {
    this.boardDao = boardDao;
    this.fileDao = fileDao;
    this.txManager = txManager;
  }

  @Override
  public List<PhotoBoard> list(int lessonNo, String searchWord) {
    
    if (lessonNo <= 0 && searchWord == null ) {
      return boardDao.findAll(null);
      
    } else {
      HashMap<String,Object> params = new HashMap<>();
      if (lessonNo > 0) {
        params.put("lessonNo", lessonNo);
      }
      if (searchWord != null) {
        params.put("keyword", searchWord);
      }
      return boardDao.findAll(params);
    }
  }

  @Override
  public int add(PhotoBoard photoBoard) {

    DefaultTransactionDefinition def = new DefaultTransactionDefinition();
    def.setName("tx1");
    def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);

    TransactionStatus status = txManager.getTransaction(def);

    try {
      int count = boardDao.insert(photoBoard);
      
      List<PhotoFile> files = photoBoard.getFiles();
      
      for (PhotoFile f : files) {
        f.setPhotoBoardNo(photoBoard.getNo());
      }
      
      fileDao.insert(photoBoard.getFiles());
      txManager.commit(status);
      return count;

    } catch (RuntimeException e) {
      txManager.rollback(status);
      throw e;
    }
  }

  @Override
  public PhotoBoard get(int no) {
    PhotoBoard board = boardDao.findByNoWithFile(no);
    if (board != null) {
      boardDao.increaseCount(no);
    }
    return board;
  }

  @Override
  public int update(PhotoBoard photoBoard) {
    
    DefaultTransactionDefinition def = new DefaultTransactionDefinition();
    def.setName("tx1");
    def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);

    TransactionStatus status = txManager.getTransaction(def);
    
    try {
      if (photoBoard.getTitle() != null) {
        boardDao.update(photoBoard);
      }
      
      List<PhotoFile> photoFiles = photoBoard.getFiles();
      
      if(photoFiles != null) {
        fileDao.deleteByPhotoBoardNo(photoBoard.getNo());
        fileDao.insert(photoFiles);
      }
      txManager.commit(status);
      return 1;

    } catch (RuntimeException e) {
      txManager.rollback(status);
      throw e;
    }
  }

  @Override
  public int delete(int no) {
    
    DefaultTransactionDefinition def = new DefaultTransactionDefinition();
    def.setName("tx1");
    def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);

    TransactionStatus status = txManager.getTransaction(def);
    
    try {
      // 데이터를 지울 때는 자식 테이블의 데이터부터 지워야 한다.
      fileDao.deleteByPhotoBoardNo(no);
      int count = boardDao.delete(no);
      txManager.commit(status);
      return count;
      
    } catch (RuntimeException e) {
      txManager.rollback(status);
      throw e;
    }
  }  
  
}
