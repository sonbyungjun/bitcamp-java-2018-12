package ch20.a;

import java.util.ArrayList;

public class Test04 {
  
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
        final int prime = 31;
        int result = 1;
        result = prime * result + age;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        return result;
      }
      @Override
      public boolean equals(Object obj) {
        if (this == obj)
          return true;
        if (obj == null)
          return false;
        if (getClass() != obj.getClass())
          return false;
        Student other = (Student) obj;
        if (age != other.age)
          return false;
        if (name == null) {
          if (other.name != null)
            return false;
        } else if (!name.equals(other.name))
          return false;
        return true;
      }
      
      
    }
    
    Student s1 = new Student("aaa", 20);
    Student s2 = new Student("bbb", 30);
    Student s3 = new Student("ccc", 40);
    Student s4 = new Student("bbb", 30);
    
    System.out.println(s2 == s4);
    System.out.println(s2.equals(s4));
    System.out.println(s2.hashCode() == s4.hashCode());
    
    ArrayList<Student> list = new ArrayList<>();
    list.add(s1);
    list.add(s2);
    list.add(s3);
    
    System.out.println(list);
    
    System.out.println(list.contains(s2));
    System.out.println(list.contains(s4));
    
  }
}
