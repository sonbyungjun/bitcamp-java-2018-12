package ch17.e;

public class BubbleSort extends Sorter {
  
  @Override
  public void sort(int[] values) {
    int size = values.length-1;
    for (int i = 0; i < size; i++) {
      for (int j = 0; j < size - i; j++) {
        if (values[j] > values[j + 1]) {
//          System.out.printf("%d <== %d\n", values[j], values[j+1]);
          int temp = values[j];
          values[j] = values[j + 1];
          values[j + 1] = temp;
        }
      }
    }
  }
  
}
