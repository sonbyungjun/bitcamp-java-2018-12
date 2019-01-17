package com.eomcs.lms.handler;

import java.util.Arrays;

public class ArrayList {

  private final int PRIMARYIDX = 2;
  private int idx = 0;
  private Object[] list;
  
  public ArrayList() {
    this.list = new Object[PRIMARYIDX];
  }
  
  public ArrayList(int index) {
    if (index > PRIMARYIDX)
      this.list = new Object[index];
  }
  
  public Object[] toArray() {
    return Arrays.copyOf(list, idx);
  }
  
  public void add(Object object) {
    int oldIdx = idx;
    int newIdx = oldIdx + (oldIdx >> 1);
    if(idx == list.length)
      list = Arrays.copyOf(list, newIdx);

    this.list[this.idx] = object;
    this.idx++;
  }
}
