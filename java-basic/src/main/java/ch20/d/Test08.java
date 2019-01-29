package ch20.d;

import java.util.Hashtable;
import java.util.Iterator;
import java.util.Set;

public class Test08 {
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

    Hashtable<String, Student> table = new Hashtable<>();

    table.put("aaa", new Student("홍길동", 20));
    table.put("bbb", new Student("임꺽정", 30));
    table.put("ccc", new Student("안중근", 25));
    
    Set<String> keySet = table.keySet();
    
    Iterator<String> iterator = keySet.iterator();
    
    System.out.println(iterator.next());
    table.put("bba", new Student("bba", 20));
    table.put("bbc", new Student("bbc", 20));
    System.out.println(iterator.next());
    
    System.out.println(iterator.next());
    
    
  }
}
