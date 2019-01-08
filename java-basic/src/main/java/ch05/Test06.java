package ch05;

public class Test06 {
  
  static enum UserType {
    MANAGER, MEMBER, GUEST
  };
  
  public static void main(String[] args) {
    UserType type = UserType.MANAGER;
    
    switch (type) {
      case MEMBER:
        System.out.println("일반회원입니다.");
        break;
      case MANAGER:
        System.out.println("관리자입니다.");
        break;
      case GUEST:
        System.out.println("손님입니다.");
        break;
      default:
        System.out.println("유효하지 않은 사용자입니다.");
    }
    
  }
}