package ch21.a;

import java.util.ArrayList;

public class Test04 {
  public static void main(String[] args) {
    ArrayList<String> list = new ArrayList<>();
    list.add("홍길동");
    list.add("임꺽정");
    list.add("유관순");

    System.out.println(list.get(0));
    System.out.println(list.get(1));
    System.out.println(list.get(2));
    
    try {
      System.out.println(list.get(3));
    } catch (Exception e) {
      System.out.println("인덱스가 무효합니다.");
    }
    
    System.out.println("프로그램 종료");
    
  }

}
