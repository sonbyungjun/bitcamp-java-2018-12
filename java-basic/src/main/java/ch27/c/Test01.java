package ch27.c;

import java.lang.reflect.Constructor;

public class Test01 {
  
  public static void main(String[] args) throws Exception {
    
    //Class<?> clazz = Student.class;
    Class<?> clazz = Class.forName("ch27.c.Student");
    
    Student s1 = (Student) clazz.newInstance();
    
    @SuppressWarnings("unchecked")
    Constructor<Student> c1 = (Constructor<Student>) clazz.getConstructor();
    Student s2 = (Student) c1.newInstance();
    
    @SuppressWarnings("unchecked")
    Constructor<Student> c2 =
        (Constructor<Student>) clazz.getConstructor(String.class, String.class);
    
    Student s3 = c2.newInstance("홍길동", "hong@test.com");
    System.out.println(s3);
  }
  
}
