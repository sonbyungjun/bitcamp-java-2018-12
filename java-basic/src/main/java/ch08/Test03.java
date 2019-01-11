package ch08;

class My3 {
  static int sa;

  int ia;
}

public class Test03 {
  public static void main(String[] args) {
    My3.sa = 100;
    
    My3 obj1 = new My3();
    My3 obj2 = new My3();
    
    obj1.ia = 200;
    obj2.ia = 300;
    
//    My3.ia = 500;
    
    obj1.sa = 500;
    
    System.out.println(My3.sa);
    
  }
}
