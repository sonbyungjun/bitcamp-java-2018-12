package com.eomcs.lms.service.impl;

import java.util.HashMap;
import java.util.List;
import org.springframework.stereotype.Service;
import com.eomcs.lms.dao.BoardDao;
import com.eomcs.lms.domain.Board;
import com.eomcs.lms.service.BoardService;

@Service
public class BoardServiceImpl implements BoardService {
  
  BoardDao boardDao;
  
  public BoardServiceImpl(BoardDao boardDao) {
    this.boardDao = boardDao;
  }

  @Override
  public List<Board> list(int pageNo, int pageSize) {
    HashMap<String,Object> params = new HashMap<>();
    params.put("size", pageSize);
    params.put("rowNo", (pageNo - 1) * pageSize);
    return boardDao.findAll(params);
  }
  
  @Override
  public int add(Board board) {
    return boardDao.insert(board);
  }
  
  @Override
  public Board get(int no) {
    Board board = boardDao.findByNo(no);
    if (board != null) {
      boardDao.increaseCount(no);
    }
    return board;
  }
  
  @Override
  public int update(Board board) {
    return boardDao.update(board);
  }
  
  @Override
  public int delete(int no) {
    return boardDao.delete(no);
  }
  
  @Override
  public int size() {
    return boardDao.countAll();
  }
}
