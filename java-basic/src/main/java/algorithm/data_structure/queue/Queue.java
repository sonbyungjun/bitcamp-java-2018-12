package algorithm.data_structure.queue;

import algorithm.data_structure.linkedlist.LinkedList;

public class Queue extends LinkedList {
  
  
  public void offer(Object value) {
    this.add(value);
  }
  
  public Object poll() {
    return this.remove(0);
  }
  
  public boolean empty() {
    return this.size == 0;
  }
}
