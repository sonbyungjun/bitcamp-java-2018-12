package algorithm.data_structure.array;

import java.util.Arrays;

public class ArrayList2<E> {

  static final int IN = 5;
  Object[] list;
  int size = 0;

  public ArrayList2() {
    this(0);
  }

  public ArrayList2(int capacity) {
    if (capacity < IN) {
      list = new Object[IN];
    } else {
      list = new Object[capacity];
    }
  }

  public E[] toArray(E[] a) {
    if (a.length < size) {
      return (E[]) Arrays.copyOf(list, size, a.getClass());
    }
    System.arraycopy(list, 0, a, 0, size);
    if (a.length > size)
      a[size] = null;
    return a;
  }

  public void add(E value) {
    if (list.length == size) {
      Object[] tmp = new Object[list.length + (list.length >> 1)];
      for (int i = 0; i < size; i++) {
        tmp[i] = list[i];
      }
      list = tmp;
    }
    list[size++] = value;
  }

  public int insert(int index, E value) {
    if (index < 0 || index >= size)
      return -1;
    for (int i = size - 1; i > 0; i--) {
      list[i+1] = list[i];
    }
    list[index] = value;
    size++;
    return 0;
  }

  @SuppressWarnings("unchecked")
  public E set(int index, E value) {
    if (index < 0 || index >= size)
      return null;
    increase();
    E old = (E) list[index];
    list[index] = value;
    return old;
  }


  @SuppressWarnings("unchecked")
  public E remove(int index) {
    if (index < 0 || index >= size)
      return null;
    E old = (E) list[index];
    for (int i = 0; i < size; i++) {
      list[i] = list[i+1];
    }
    size--;
    return old;
  }

  @SuppressWarnings("unchecked")
  public E get(int index) {
    if (index < 0 || index >= size)
      return null;
    return (E) list[index];
  }

  public int size() {
    return this.size;
  }

  private void increase() {
    if (list.length == size) {
      Object[] tmp = new Object[list.length + (list.length >> 1)];
      for (int i = 0; i < size; i++) {
        tmp[i] = list[i];
      }
      list = tmp;
    }
  }
}
