package ch21.d;

import java.util.ArrayList;

public class Test01 {
  static ArrayList<String> list = new ArrayList<>();
  
  public static void main(String[] args) {
    addName("홍길동");
    addName("임꺽정");
    addName("유관순");
    
    System.out.println(getName(0));
    System.out.println(getName(1));
    System.out.println(getName(2));
    System.out.println(getName(3));
    
    System.out.printf("입력된 이름 개수는 %d 입니다.\n", list.size());
  }
  
  static void addName(String name) {
    list.add(name);
  }
  
  static String getName(int index) {
    return list.get(index);
  }
  
}
