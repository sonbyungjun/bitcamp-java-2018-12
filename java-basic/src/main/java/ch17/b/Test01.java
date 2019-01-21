package ch17.b;

public class Test01 {
  public static void main(String[] args) {
    int[] values = {23, 7, 12, 15, 9, 2, 22, 8, 11, 25, 13, 5};
    int[] values2 = {23, 7, 12, 15, 9, 2, 22, 8, 11, 25, 13, 5};
    
    BubbleSort s1 = new BubbleSort();
    QuickSort s2 = new QuickSort();

    display(s1, values);
    display(s2, values2);
  }
  
  static void display(BubbleSort sorter, int[] values) {
    sorter.run(values);
    for (int value : values) {
      System.out.printf(value + ",");
    }
    System.out.println();
  }
  
  static void display(QuickSort sorter, int[] values) {
    sorter.start(values, 0, values.length-1);
    for (int value : values) {
      System.out.printf(value + ",");
    }
  }
}
