package ch14.f;

public class Test02 {

  public static void main(String[] args) {
    A obj = new B();
    obj.m1();
//    obj.m2();
    
//    B obj2 = obj;
    
    B obj2 = (B) obj;
    obj2.m2();
    
    if (obj == obj2)
      System.out.println("obj == obj2");
    
    A obj3 = new A();
    
    B obj4 = (B) obj3;
    
    obj4.m1();
    
  }

}
