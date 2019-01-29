package ch21.a;

import java.util.ArrayList;

public class Test02 {
  public static void main(String[] args) {
    ArrayList<long[]> list = new ArrayList<>();
    try {
//      System.out.println(sum(100000));
      for (int i = 0; i < 1000; i++) {
        list.add(new long[1000000]);
      }
    } catch (Error err) {
      System.out.println(list.size());
      System.out.println("시스템 예외가 발생했습니다!");
    }
    
    list.add(new long[1000000]);
    
    
    System.out.println("실행 완료");
  }
  
}
