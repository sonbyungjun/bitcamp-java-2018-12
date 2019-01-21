package ch17.e;

public class Test01 {
  public static void main(String[] args) {
    int[] values = {23, 7, 12, 15, 9, 2, 22, 8, 11, 25, 13, 5};
    int[] values2 = {23, 7, 12, 15, 9, 2, 22, 8, 11, 25, 13, 5};
    int[] values3 = {23, 7, 12, 15, 9, 2, 22, 8, 11, 25, 13, 5};

    display(new BubbleSort(), values);
    display(new QuickSort(), values2);
    display(new MergeSort(), values3);
    
//    display(new Sorter(), values3);
  }
  
  static void display(Sorter sorter, int[] values) {
    sorter.sort(values);
    for (int value : values) {
      System.out.printf(value + ",");
    }
    System.out.println();
  }
}
