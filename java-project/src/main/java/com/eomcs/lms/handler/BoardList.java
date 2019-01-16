package com.eomcs.lms.handler;

import com.eomcs.lms.domain.Board;

public class BoardList {
  
  private int index;
  private int idx = 0;
  Board[] boards;
  
  public BoardList(int index) {
    this.index = index;
    this.boards = new Board[this.index];
  }
  
  
  public Board[] toArray() {
    Board[] b1 = this.boards;
    Board[] b2 = new Board[idx];
    for (int i = 0; i < this.idx; i++) {
      b1[i] = b2[i];
    }
    return b2;
  }
  
  public void add(Board board) {
    
    if (idx <= this.boards.length) {
      Board[] b1 = new Board[];
    }
    this.boards[this.idx] = board;
    this.idx++;
  }
}
