package design_pattern.iterator;

public class ArrayList<E> {
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
  
  public void add(E value) {
    if (arr.length == size)
      increase();
    arr[size++] = value;
  }

  public int insert(int index, E value) {
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

  @SuppressWarnings("unchecked")
  public E set(int index, E value) {
    if (index < 0 || index > size)
      return null;
    E oldValue = (E) arr[index];
    arr[index] = value;
    return (E) oldValue;
  }


  @SuppressWarnings("unchecked")
  public E remove(int index) {
    if (index < 0 || index > size)
      return null;
    E oldvalue = (E) arr[index];
    
    for (int i = index; i < size-1; i++) {
      this.arr[i] = this.arr[i+1];
    }
    size--;
    return oldvalue;
  }

  @SuppressWarnings("unchecked")
  public E get(int index) {
    if (index < 0 || index > size)
      return null;
    return (E) this.arr[index];
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
