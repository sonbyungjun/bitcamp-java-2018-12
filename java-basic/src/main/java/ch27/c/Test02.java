package ch27.c;

import java.lang.reflect.Method;

public class Test02 {
  
  public static void main(String[] args) throws Exception {
    
    Student s1 = new Student("홍길동","hong@test.com", true, 25);
    System.out.println(s1);
    Method m1 = s1.getClass().getMethod("setName", String.class);
    m1.invoke(s1, "임꺽정");
    System.out.println(s1);
    
    Method m2 = s1.getClass().getMethod("greeting", String.class, int.class, boolean.class);
    System.out.println(m2.invoke(null, "홍길동", 20, true));
  }
  
}
