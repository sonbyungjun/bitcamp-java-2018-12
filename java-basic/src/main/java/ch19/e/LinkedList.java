package ch19.e;

public class LinkedList {
  
  public static final int FORWARD = 1;
  public static final int REVERSE = 2;
  
  protected Node head;
  protected Node tail;
  protected int size;

  public LinkedList() {
    head = new Node();
    tail = head;
    size = 0;
  }

  public void add(Object value) {
    tail.value = value;
    Node node = new Node();
    tail.next = node;
    node.prev = tail;
    tail = node;
    size++;
  }

  public int size() {
    return size;
  }

  public Object get(int index) {
    if (index < 0 || index >= size)
      return null;
    Node cursor = head;
    for (int i = 1; i <= index; i++) {
      cursor = cursor.next;
    }
    return cursor.value;
  }

  public Object[] toArray(int direction) {
    Array helper = new Array(this);
    if (direction == FORWARD) {
     return helper.copy(); 
    } else {
      return helper.reverseCopy();
    }
    
  }

  public Object set(int index, Object value) {
    if (index < 0 || index >= size)
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
    if (index < 0 || index >= size)
      return -1;
    Node node = new Node(value);
    Node cursor = head;
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

  public Object remove(int index) {
    if (index < 0 || index >= size)
      return null;
    Node cursor = head;
    for (int i = 1; i <= index; i++) {
      cursor = cursor.next;
    }
    Object old = cursor.value;
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
}
