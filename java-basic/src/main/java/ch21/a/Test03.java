package ch21.a;

import java.util.ArrayList;

public class Test03 {
  public static void main(String[] args) {
    ArrayList<String> list = new ArrayList<>();
    list.add("홍길동");
    list.add("임꺽정");
    list.add("유관순");

    System.out.println(list.get(0));
    System.out.println(list.get(1));
    System.out.println(list.get(2));
    
    System.out.println(list.get(3));
    
    System.out.println("프로그램 종료");
    
  }

}
