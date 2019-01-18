package ch15;

class My5 {
  String name;
  int age;
  
  
  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    My5 other = (My5) obj;
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

public class Test05 {
  public static void main(String[] args) {
    My5 obj1 = new My5();
    obj1.name = "홍길동";
    obj1.age = 20;

    My5 obj2 = new My5();
    obj2.name = "홍길동";
    obj2.age = 20;

    System.out.println(obj1 == obj2);
    System.out.println(obj1.equals(obj2));


  }
}
