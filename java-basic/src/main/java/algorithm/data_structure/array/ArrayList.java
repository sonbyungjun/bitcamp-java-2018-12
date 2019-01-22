package algorithm.data_structure.array;


public class ArrayList {
  static final int DEFAULT_SIZE = 5;
  Object[] arr;
  private int size;

  public ArrayList() {
    this(0);
  }

  public ArrayList(int capacity) {
    if (capacity > DEFAULT_SIZE)
      this.arr = new Object[capacity];
    else
      this.arr = new Object[DEFAULT_SIZE];
  }

  public Object[] toArray() {
    Object[] list = new Object[this.size];
    for (int i = 0; i < this.size; i++) {
      list[i] = this.arr[i];
    }
    return list;
  }
  
  public void add(Object value) {
    if (arr.length == size)
      increase();
    arr[size++] = value;
  }

  public int insert(int index, Object value) {
    if (index < 0 || index > size)
      return -1;
    if (arr.length == size)
      increase();
    for(int i = size - 1; i >= index; i--) 
      arr[i+1] = arr[i];
    arr[index] = value;
    size++;
    return 0;
  }

  public Object set(int index, Object value) {
    if (index < 0 || index > size)
      return null;
    Object oldValue = arr[index];
    arr[index] = value;
    return oldValue;
  }


  public Object remove(int index) {
    if (index < 0 || index > size)
      return null;
    Object oldvalue = arr[index];
    
    for (int i = index; i < size-1; i++) {
      this.arr[i] = this.arr[i+1];
    }
    size--;
    return oldvalue;
  }

  public Object get(int index) {
    if (index < 0 || index > size)
      return null;
    return this.arr[index];
  }

  public int size() {
    return this.size;
  }

  private void increase() {
    int originSize = arr.length;
    int newSize = originSize + (originSize >> 1);
    Object[] temp = new Object[newSize];
    for (int i = 0; i < this.arr.length; i++) {
      temp[i] = this.arr[i];
    }
    arr = temp;
  }
}
