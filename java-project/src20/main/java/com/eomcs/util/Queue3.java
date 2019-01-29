package com.eomcs.util;

import java.util.Arrays;

public class Queue3<E> {
  Object[] list;
  int size;
  
  public Queue3() {
    list = new Object[5];
    size = 0;
  }
  
  public void offer(E value) {
    if (list.length == size) {
      Arrays.copyOf(list, list.length + (list.length >> 1));
    }
    list[size++] = value;
  }
  
  @SuppressWarnings("unchecked")
  public E poll() {
    E value = (E) list[0];
    for (int i = size-1; i > 0; i--) {
      list[i-1] = list[i];
    }
    size--;
    return value;
  }
  
  public boolean empty() {
    return this.size == 0;
  }
}
