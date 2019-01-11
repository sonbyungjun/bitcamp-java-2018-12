package ch08;

class My2 {
  static String manager = "관리자";
  static String member = "회원";
  static String guest = "손님";
  
  String name;
  int age;
  String userType;
}

public class Test02 {
  public static void main(String[] args) {
    System.out.println(My2.manager);
    System.out.println(My2.member);
  }
}
