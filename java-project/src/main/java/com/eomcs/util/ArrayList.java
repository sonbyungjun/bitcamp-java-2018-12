package com.eomcs.util;

import java.util.Arrays;

public class ArrayList<E> {
  static final int DEFAULT_CAPACITY = 10;
  private Object[] list;
  private int size = 0;

  public ArrayList() {
    list  = new Object[DEFAULT_CAPACITY];
  }
  
  public int getSize() {
    return size;
  }

  public ArrayList(int initialCapacity) {
    if (initialCapacity > DEFAULT_CAPACITY)
      list = new Object[initialCapacity];
    else
      list = new Object[DEFAULT_CAPACITY];
  }

  @SuppressWarnings("unchecked")
  public E[] toArray(E[] a) {
    return (E[]) Arrays.copyOf(list, size, a.getClass());
  }

  public void add(E obj) {
    if (size >= list.length) {
      int oldCapacity = list.length;
      int newCapacity = oldCapacity + (oldCapacity >> 1);
      list = Arrays.copyOf(list, newCapacity);
    }

    list[size++] = obj;
  }
  
  @SuppressWarnings("unchecked")
  public E get(int index) {
    if (index == -1) 
      return null;
    E a = (E) list[index];
    return a;
  }
  
  public void set(int i, E obj) {
    list[i] = obj;
  }
  
  public void delete(int index) {
    Object tmp = null;
    for (int i = index; i < size; i++) {
      tmp = list[i+1];
      list[i] = tmp;
    }
    size--;
  }
  
}
