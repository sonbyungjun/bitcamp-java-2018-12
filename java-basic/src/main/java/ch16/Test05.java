package ch16;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Test05 {
  public static void main(String[] args) {
    
    String[] strs = create2(new String[0]);
    System.out.println(strs.length);

    String[] temp = new String[100]; 
    String[] strs2 = create2(new String[100]);
    System.out.println(strs2.length);
    System.out.println(temp == strs2);
    
    String[] strs3 = create3(String.class);
    System.out.println(strs3.length);
  }
  
  
  static <T> T[] create1() {
//    T[] arr = new T[10];
    return null;
  }
  
  static <T> T[] create2(T[] arr) {
    return Arrays.copyOf(arr, 10);
  }
  
  @SuppressWarnings("unchecked")
  static <T> T[] create3(Class<?> type) {
    return (T[]) Array.newInstance(type, 10);
  }
  
  @SuppressWarnings("unchecked")
  static <T> T[] create4(T[] arr) {
    return (T[]) Array.newInstance(arr.getClass(), 10);
  }
  
}
