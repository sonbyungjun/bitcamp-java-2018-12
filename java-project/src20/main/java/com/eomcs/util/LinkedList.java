package com.eomcs.util;

import java.lang.reflect.Array;

public class LinkedList<E> implements Cloneable {
  protected Node<E> head;
  protected Node<E> tail;
  protected int size;

  public LinkedList() {
    head = new Node<>();
    tail = head;
    size = 0;
  }

  public void add(E value) {
    tail.value = value;
    Node<E> node = new Node<>();
    tail.next = node;
    node.prev = tail;
    tail = node;
    size++;
  }

  public int size() {
    return size;
  }

  public E get(int index) {
    if (index < 0 || index >= size)
      return null;
    Node<E> cursor = head;
    for (int i = 1; i <= index; i++) {
      cursor = cursor.next;
    }
    return cursor.value;
  }

  public Object[] toArray() {
    Object[] arr = new Object[size];
    Node<E> cursor = head;
    for (int i = 0; i < size; i++) {
      arr[i] = cursor.value;
      cursor = cursor.next;
    }
    return arr;
  }
  
  @SuppressWarnings("unchecked")
  public <T> T[] toArray(T[] a) {
    T[] arr = null;
    if (a.length >= size()) {
      arr = a;
    } else {
      arr = (T[]) Array.newInstance(a.getClass().getComponentType(), this.size);
    }
    Node<E> cursor = head;
    for (int i = 0; i < size; i++) {
      arr[i] = (T) cursor.value;
      cursor = cursor.next;
    }
    return arr;
  }

  public E set(int index, E value) {
    if (index < 0 || index >= size)
      return null;
    Node<E> cursor = head;
    for (int i = 1; i <= index; i++) {
      cursor = cursor.next;
    }
    E old = cursor.value;
    cursor.value = value;
    return old;
  }

  public int insert(int index, E value) {
    if (index < 0 || index >= size)
      return -1;
    Node<E> node = new Node<>(value);
    Node<E> cursor = head;
    for (int i = 1; i <= index; i++) {
      cursor = cursor.next;
    }
    node.next = cursor;
    node.prev = cursor.prev;
    cursor.prev = node;
    if (node.prev != null) {
      node.prev.next = node;
    } else {
      head = node;
    }
    size++;
    return 0;
  }

  public E remove(int index) {
    if (index < 0 || index >= size)
      return null;
    Node<E> cursor = head;
    for (int i = 1; i <= index; i++) {
      cursor = cursor.next;
    }
    E old = cursor.value;
    if (cursor.prev != null) {
      cursor.prev.next = cursor.next;
    } else {
      head = cursor.next;
    }
    cursor.next.prev = cursor.prev;
    cursor.value = null;
    cursor.prev = null;
    cursor.next = null;
    size--;
    return old;
  }
  
  
  private static class Node<E> {
    E value;
    Node<E> prev;
    Node<E> next;
    Node() {
    }
    Node(E value) {
      this.value = value;
    }
  }
  
  
}
