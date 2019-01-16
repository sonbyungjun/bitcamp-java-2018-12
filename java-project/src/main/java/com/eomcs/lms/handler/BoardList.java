package com.eomcs.lms.handler;

import com.eomcs.lms.domain.Board;

public class BoardList {
  
  private final int PRIMARYIDX = 10;
  private int idx = 0;
  private Board[] boards;
  
  public BoardList() {
    this.boards = new Board[PRIMARYIDX];
  }
  
  public BoardList(int index) {
    if (index > PRIMARYIDX)
      this.boards = new Board[index];
  }
  
  
  public Board[] toArray() {
    Board[] b2 = new Board[this.idx];
    for (int i = 0; i < this.idx; i++) {
      b2[i] = this.boards[i];
    }
    return b2;
  }
  
  public void add(Board board) {
    int oldIdx = idx;
    int newIdx = oldIdx + (oldIdx * 2);
    
    if (idx >= this.boards.length) {
      Board[] b1 = new Board[newIdx];
      
      for (int i = 0; i < idx; i++) {
        b1[i] = boards[i];
      }
      this.boards = b1;
    }
    
    this.boards[this.idx] = board;
    this.idx++;
    
  }
}
