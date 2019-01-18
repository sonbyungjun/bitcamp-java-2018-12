package com.eomcs.lms.handler;

import java.util.Arrays;

public class ArrayList<E> {

  private final int PRIMARYIDX = 10;
  private int idx = 0;
  private E[] list;
  
  @SuppressWarnings("unchecked")
  public ArrayList(E[] arr) {
    this.list = Arrays.copyOf(arr, PRIMARYIDX);
  }
  
  @SuppressWarnings("unchecked")
  public ArrayList(E[] arr, int index) {
    if (index > PRIMARYIDX)
      this.list = Arrays.copyOf(arr, index);
    else
      this.list = Arrays.copyOf(arr, PRIMARYIDX);
  }
  
  public E[] toArray() {
    return Arrays.copyOf(list, idx);
  }
  
  public void add(E obj) {
    int oldIdx = idx;
    int newIdx = oldIdx + (oldIdx >> 1);
    if(idx == list.length)
      list = Arrays.copyOf(list, newIdx);

    this.list[this.idx] = obj;
    this.idx++;
  }
}
