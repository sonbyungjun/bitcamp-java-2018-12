package com.eomcs.util;

public class Queue2<E> extends LinkedList<E> {
  Object[] list;
  int size;
  
  public void offer(E value) {
    list[size++] = value;
    this.add(value);
  }
  
  public E poll() {
    return this.remove(0);
  }
  
  public boolean empty() {
    return this.size == 0;
  }
}
