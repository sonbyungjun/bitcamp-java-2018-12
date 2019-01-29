package ch21.d;

import java.util.ArrayList;

public class Test03 {
  static ArrayList<String> list = new ArrayList<>();

  public static void main(String[] args) {
    addName("홍길동");
    addName("임꺽정");
    addName(null);
    addName(null);
    addName("유관순");

    for (int i = 0; i <= list.size(); i++) {
      try {
        String name = getName(i);
        System.out.println(getName(i));
      } catch (Exception e) {
        System.out.println("목록에서 데이터를 꺼낸 중에 오류 발생!");
      }
    }
    System.out.printf("입력된 이름 개수는 %d 입니다.\n", list.size());

    try {
      int result = divide(1919191919, -1);
      System.out.println(result);
    } catch (Exception e) {
      System.out.println("나누기 오류입니다.");
    }

  }

  static void addName(String name) {
    list.add(name);
  }

  static String getName(int index) throws Exception {
    if (index < 0 || index >= list.size())
      throw new Exception("무효한 인덱스입니다.");

    return list.get(index);
  }

  static int divide(int a, int b) throws Exception {
    if (b == 0) {
      throw new Exception("0으로 나눌 수 없습니다.");
    }
    return a / b;
  }
}
