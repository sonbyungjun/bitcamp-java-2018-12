package design_pattern.iterator;

import algorithm.data_structure.linkedlist3.LinkedList;

public class Queue<E> extends LinkedList<E> {
  
  public void offer(E value) {
    this.add(value);
  }
  
  public E poll() {
    return this.remove(0);
  }
  
  public boolean empty() {
    return this.size == 0;
  }
  
  public Iterator<E> iterator() {
    return new Iterator<E>() {
      int index = 0;
      @Override
      public boolean hasNext() {
        return index < size();
      }
      @Override
      public E next() {
        return get(index++);
      }
    };
  }
  
  
}
