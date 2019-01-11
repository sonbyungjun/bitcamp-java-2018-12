package ch08;

class My1 {
  static String manager = "관리자";
  static String member = "회원";
  static String guest = "손님";
  
  String name;
  int age;
  String userType;
}

public class Test01 {
  public static void main(String[] args) {
    
    My1 obj1 = new My1();
    obj1.name = "홍길동";
    obj1.age = 20;
    obj1.userType = My1.member;
    
    My1 obj2 = new My1();
    obj2.name = "임꺽정";
    obj2.age = 30;
    obj2.userType = My1.manager;
    
    My1 obj3 = new My1();
    obj3.name = "유관순";
    obj3.age = 17;
    obj3.userType = My1.guest;
    
    My1 obj4 = new My1();
    obj4.name = "윤봉길";
    obj4.age = 22;
    obj4.userType = My1.member;
  }
}
