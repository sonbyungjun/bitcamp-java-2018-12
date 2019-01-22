package algorithm.data_structure.array;

public class Test01 {
  public static void main(String[] args) {
    ArrayList arr = new ArrayList();
    arr.add(0);
    arr.add(1);
    arr.add(2);
    arr.add(3);
    arr.add(4);
    arr.add(5);
    arr.add(6);
    arr.add(7);
    
    
    print(arr);
    
    
    arr.insert(2, 124);
    
    print(arr);
   
    arr.remove(2);
    
    print(arr);
    
    arr.set(2, 100);
    print(arr);
    
//    int[] a = arr.toArray();
    
  }
  
  static public void print(ArrayList arr) {
    for (int i = 0; i < arr.size(); i++) {
      System.out.print(arr.get(i) + ", ");
    }
    System.out.println();
  }
}
