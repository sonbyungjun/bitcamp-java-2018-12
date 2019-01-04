package ch02;

public class Test12 {
  public static void main(String[] args) {
    System.out.printf("Hello!\n");
    
    System.out.printf("이름: %s\n", "홍길동");
    System.out.printf("안녕하세요! %s입니다.\n", "임꺽정");

    System.out.printf("%d %x %c %b\n", 65, 65, 65, true);
    
    System.out.printf("%2$d %2$x %2$c \n", 65, 66, 67);
    
    System.out.printf("'%-10s' '%10s'\n", "홍길동", "임꺽정");
    
    System.out.printf("'%-10d' '%10d'\n", 12345, 12345);
    
    System.out.printf("'%010d' '%07d'\n", 12345, 12345);
    
    System.out.printf("'%+010d' '%+07d'\n", 12345, -12345);
  }
}
