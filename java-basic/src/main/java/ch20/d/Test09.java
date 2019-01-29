package ch20.d;

import java.util.Enumeration;
import java.util.Hashtable;

public class Test09 {
  public static void main(String[] args) {
    class Student {
      String name;
      int age;

      public Student(String name, int age) {
        this.name = name;
        this.age = age;
      }

      @Override
      public String toString() {
        return "Sudent [name=" + name + ", age=" + age + "]";
      }
    }

    Hashtable<String, Student> map = new Hashtable<>();

    map.put("aaa", new Student("홍길동", 20));
    map.put("bbb", new Student("임꺽정", 30));
    map.put("ccc", new Student("안중근", 25));
    
    Enumeration<Student> values1 = map.elements();
    while (values1.hasMoreElements()) {
      System.out.println(values1.nextElement());
    }

    
  }
}
