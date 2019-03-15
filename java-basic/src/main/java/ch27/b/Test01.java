package ch27.b;

public class Test01 {
  
  public static void main(String[] args) throws Exception {
    
    Class<?> clazz = Calculator.class;
    
    System.out.println(clazz.getName());
    System.out.println(clazz.getCanonicalName());
    System.out.println(clazz.getSimpleName());
    
  }
  
}
