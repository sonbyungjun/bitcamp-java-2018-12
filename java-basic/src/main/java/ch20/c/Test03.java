package ch20.c;

import java.util.HashSet;
import java.util.Iterator;

public class Test03 {
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
        return "Student [name=" + name + ", age=" + age + "]";
      }

      @Override
      public int hashCode() {
//        final int prime = 31;
//        int result = 1;
//        result = prime * result + age;
//        result = prime * result + ((name == null) ? 0 : name.hashCode());
//        return result;
        return 1;
      }

      @Override
      public boolean equals(Object obj) {
//        if (this == obj)
//          return true;
//        if (obj == null)
//          return false;
//        if (getClass() != obj.getClass())
//          return false;
//        Student other = (Student) obj;
//        if (age != other.age)
//          return false;
//        if (name == null) {
//          if (other.name != null)
//            return false;
//        } else if (!name.equals(other.name))
//          return false;
        return true;
      }

      
    }

    HashSet<Student> set = new HashSet<>();
    set.add(new Student("aaa", 20));
    set.add(new Student("bbb", 30));
    set.add(new Student("ccc", 40));

    set.add(new Student("aaa", 20));
    set.add(new Student("bbb", 30));


    Iterator<Student> iterator = set.iterator();

    while (iterator.hasNext()) {
      System.out.println(iterator.next());
    }
    System.out.println("-------------------------------");

    Object[] values = set.toArray();

    for (Object value : values) {
      System.out.println(value);
    }
    System.out.println("-------------------------------");

    Student[] values2 = set.toArray(new Student[0]);
    for (Object value : values2) {
      System.out.println(value);
    }

  }
}
