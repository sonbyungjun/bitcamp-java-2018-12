package ch21.d;

import java.util.ArrayList;

public class Test02 {
  static ArrayList<String> list = new ArrayList<>();

  public static void main(String[] args) {
    addName("홍길동");
    addName("임꺽정");
    addName(null);
    addName(null);
    addName("유관순");

    for (int i = 0; i < list.size(); i++) {
      String name = getName(i);

      if (name == null) {
        System.out.println("목록에서 데이터를 꺼낸 중에 오류 발생!");
      } else {
        System.out.println(getName(i));
      }

    }
    
    int result = divide(1919191919, -1);
    if (result == -1919191919) {
      System.out.println("나누기 오류입니다.");
    } else {
      System.out.println(result);
    }
    
    System.out.printf("입력된 이름 개수는 %d 입니다.\n", list.size());
  }

    static void addName(String name) {
      list.add(name);
    }

    static String getName(int index) {
      if (index < 0 || index >= list.size())
        return null;

      return list.get(index);
    }

    static int divide(int a, int b) {
      if (b == 0) {
        return -1919191919;
      }
      return a / b;
    }
  }
