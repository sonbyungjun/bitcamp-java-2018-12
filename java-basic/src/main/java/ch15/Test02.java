package ch15;

class My2 {
  
}

public class Test02 {

  public static void main(String[] args) {
    My2 obj = new My2();

    System.out.println(obj.toString());
    
    My2 obj2 = new My2();
    My2 obj3 = new My2();
    
    if (obj2 == obj3)
      System.out.println("같다");
    else
      System.out.println("다르다");
  System.out.println(obj2.toString());
  System.out.println(obj3.toString());
  }

}
