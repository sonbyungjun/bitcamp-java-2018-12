package com.eomcs.util;

public class Queue<E> extends LinkedList<E> implements Cloneable {
  int size;
  
  public void offer(E value) {
    this.add(value);
  }
  
  public E poll() {
    return this.remove(0);
  }
  
  public boolean empty() {
    return this.size == 0;
  }
  
  @SuppressWarnings("unchecked")
  @Override
  public Queue<E> clone() throws CloneNotSupportedException {
    Queue<E> temp = new Queue<>();
    for (int i = 0; i < this.size(); i++) {
      temp.add(this.get(i));
    }
    return temp;
  }
}
