package algorithm.data_structure.stack2;

public class Stack<E> {
  
  public static final int DEFAULT_SIZE = 5;
  Object[] list;
  int size;
  
  public Stack() {
    list = new Object[DEFAULT_SIZE];
  }
  
  public void push(E value) {
    if (list.length == size) {
      Object[] arr = new Object[list.length + (list.length >> 1)];
      for (int i = 0; i < size; i++) {
        arr[i] = list[i];
      }
      list = arr;
    }
    list[size++] = value;
  }
  
  @SuppressWarnings("unchecked")
  public E pop() {
    if (size == 0)
      return null;
    return (E) list[--size];
  }
  
  public boolean empty() {
    return size == 0;
  }
  
  public int size() {
    return this.size;
  }
}
