package algorithm.data_structure.linkedlist;

public class LinkedList {
  protected Node head;
  protected Node tail;
  protected int size;
  
  public LinkedList() {
    head = new Node();
    tail = head;
  }
  
  public void add(Object value) {
    tail.value = value;
    Node node = new Node();
    node.prev = tail.next;
    tail.next = node;
    tail = node;
    size++;
  }
  
  public int size() {
    return size;
  }
  
  public Object get(int index) {
    if (index < 0 || index > size)
      return null;
    Node cursor = head;
    for (int i = 1; i <= index; i++) {
      cursor = cursor.next;
    }
    return cursor.value;
  }
  
  public Object[] toArray() {
    Object[] arr = new Object[size()];
    Node cursor = head;
    for (int i = 0; i < size; i++) {
      arr[i] = cursor.value;
      cursor = cursor.next;
    }
    return arr;
  }
  
  public Object set(int index, Object value) {
    if (index < 0 || index > size)
      return null;
    Node cursor = head;
    for (int i = 1; i <= index; i++) {
      cursor = cursor.next;
    }
    Object old = cursor.value;
    cursor.value = value;
    return old;
  }
  
  public int insert(int index, Object value) {
    if (index < 0 || index > size)
      return -1;
    Node cursor = head;
    for (int i = 1; i <= index; i++) {
      cursor = cursor.next;
    }
    Node node = new Node(value);
    if (cursor.prev != null)
      cursor.prev.next = node;
    cursor.prev = node;
    node.next = cursor;
    node.prev = cursor.prev;
    return 0;
  }
  
  public Object remove(int index) {
    return null;
  }
}
