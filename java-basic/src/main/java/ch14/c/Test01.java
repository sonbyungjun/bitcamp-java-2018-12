package ch14.c;

public class Test01 {

  public static void main(String[] args) {
    Calculrator obj = new Calculrator();
    obj.plus(100);
    obj.plus(20,30);
    obj.plus(new int[] {30, 30, 20});
    
    System.out.println(obj.result);
    
    Calculrator2 obj2 = new Calculrator2();
    
    obj2.plus(100);
    obj2.minus(50);
    obj2.minus(30, 10);
    
    System.out.println(obj2.result);
  }

}
