package com.eomcs.util;

import java.util.Arrays;

public class ArrayList<E> {
  static final int DEFAULT_CAPACITY = 10;
  private Object[] list;
  private int size = 0;

  public ArrayList() {
    list  = new Object[DEFAULT_CAPACITY];
  }
  

  public ArrayList(int initialCapacity) {
    if (initialCapacity > DEFAULT_CAPACITY)
      list = new Object[initialCapacity];
    else
      list = new Object[DEFAULT_CAPACITY];
  }

  public int getSize() {
    return size;
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
  
  public E set(int i, E obj) {
    list[i] = obj;
    return obj;
  }
  
  public E remove(int index) {
//    Object[] firstArr = Arrays.copyOf(list, index);
//    Object[] secondArr = Arrays.copyOfRange(list, index+1, list.length);
//    
//    Object[] resultArr = new Object[firstArr.length + secondArr.length];
//    
//    System.arraycopy(firstArr, 0, resultArr, 0, firstArr.length);
//    System.arraycopy(secondArr, 0, resultArr, firstArr.length, secondArr.length);
//    
//    size--;
    @SuppressWarnings("unchecked")
    E obj = (E) list[index];
    
    for (int i = index; i < size-1; i++) {
      list[i] = list[i+1];
    }
    size--;
    return obj;
  }
}
















