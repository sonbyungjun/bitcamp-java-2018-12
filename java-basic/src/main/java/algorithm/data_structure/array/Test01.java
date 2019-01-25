package algorithm.data_structure.array;

public class Test01 {
  
  

  static ArrayList2<Integer> list;
  
  public static void main(String[] args) {
    
    
    
    list = new ArrayList2<>();
    
    list.add(100);
    list.add(200);
    list.add(300);
    list.add(400);
    list.add(500);
    list.add(600);
    list.add(700);
    list.add(800);
    
  
    list.remove(0);
    print();
    list.remove(6);
    
  }
  
  public static void print() {
    for (int i = 0; i < list.size; i++) {
      System.out.print(list.get(i) + " ,");
    }
    System.out.println();
  }
}
