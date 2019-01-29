package ch20.d;

import java.util.HashMap;

public class Test10 {
  public static void main(String[] args) {
    class Key {
      int major;
      int minor;
      public Key(int major, int minor) {
        this.major = major;
        this.minor = minor;
      }
      @Override
      public String toString() {
        return "Key [major=" + major + ", minor=" + minor + "]";
      }
    }
    
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
    
    Key k1 = new Key(100, 1);
    Key k2 = new Key(100, 2);
    Key k3 = new Key(100, 3);
    
    HashMap<Key, Student> map = new HashMap<>();

    map.put(k1, new Student("홍길동", 20));
    map.put(k2, new Student("임꺽정", 30));
    map.put(k3, new Student("윤봉길", 20));
    
    System.out.println(map.get(k1));
    System.out.println(map.get(k2));
    System.out.println(map.get(k3));
    
    Key k4 = new Key(100, 2);
    System.out.println(map.get(k4));
    
    System.out.println(k2 == k4);
    System.out.println(k2.hashCode() == k4.hashCode());
    System.out.println(k2.equals(k4));
    
    
  }
}
