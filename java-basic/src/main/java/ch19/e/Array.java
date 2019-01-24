package ch19.e;

public class Array {
  LinkedList list;
  
  public Array(LinkedList list) {
    this.list = list;
  }
  
  public Object[] copy() {
    Object[] arr = new Object[list.size()];
    for (int i = 0; i < list.size(); i++) {
      arr[i] = list.get(i);
    }
    return arr;
  }
  
  public Object[] reverseCopy() {
    Object[] arr = new Object[list.size()];
    for (int i = list.size() - 1, j = 0; i >= 0; i--, j++) {
      arr[j] = list.get(i);
    }
    return arr;
  }
}
