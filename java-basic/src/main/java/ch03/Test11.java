package ch03;

public class Test11 {
  public static void main(String[] args) {
    int a1, a2, a3, a4, a5;
    a1 = 100;
    a2 = 90;
    a3 = 80;
    a4 = 70;
    a5 = 60;
//    int arr[5]; c언어 스타일
    
    int[] arr1;
    int arr2[];
    
//    arr1 = null;
//    arr1[0] = 100;
    
//    arr1[0] = 100;
    
    arr1 = new int[5];
    arr2 = new int[5];
    
    arr1[0] = 100;
    arr1[1] = 90;
    arr1[2] = 80;
    arr1[3] = 70;
    arr1[4] = 60;
//    arr1[-1] = 100; 오류
//    arr[5] = 50; 오류
    
    
  }
}
