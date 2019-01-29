package ch20.d;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class Test07 {
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

    HashMap<String, Student> map = new HashMap<>();

    map.put("aaa", new Student("홍길동", 20));
    map.put("bbb", new Student("임꺽정", 30));
    map.put("ccc", new Student("안중근", 25));
    
    Set<String> keySet = map.keySet();
    
    Iterator<String> iterator = keySet.iterator();
    
    System.out.println(iterator.next());
    map.put("bba", new Student("bba", 20));
    map.put("bbc", new Student("bbc", 20));
    System.out.println(iterator.next());
    
    System.out.println(iterator.next());
    
    
  }
}
