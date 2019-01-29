package ch21.c;

import java.util.ArrayList;

public class Test07 {
  
  public static void main(String[] args) {
    ArrayList<String> list = new ArrayList<>();
    list.add("홍길동");
    list.add("임꺽정");
    list.add("유관순");
    
    try {
      System.out.println(list.get(0));
      System.out.println(list.get(1));
      System.out.println(list.get(2));
      System.out.println(list.get(3));
    } catch (RuntimeException e) {
      System.out.println("실행 중 오류 발생!");
    }
    
    System.out.println("종료!");
  }
  
}
