package ch03;

public class Test13 {
  public static void main(String[] args) {
    int[] arr1;
    arr1 = new int[5];
    
    arr1[0] = 100;
    arr1[1] = 90;
    arr1[2] = 80;
    arr1[3] = 70;
    arr1[4] = 60;
    
    int[] arr2 = new int[5];
    
    int[] arr3 = new int[] {100, 100, 90, 90, 60};
    
    int[] arr4 = {100, 90, 80, 70, 60};
    
    int[] arr5;
//    arr5 = {90, 90, 90, 90, 90}; // 컴파일 오류
    arr5 = new int[] {90, 90, 90, 90, 90};
  }
}
