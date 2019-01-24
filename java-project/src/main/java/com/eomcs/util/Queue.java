package com.eomcs.util;

public class Queue<E> {
  Object[] list;
  int size;
  
  public Queue() {
    list = new Object[5];
    size = 0;
  }
  
  public void offer(E value) {
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
