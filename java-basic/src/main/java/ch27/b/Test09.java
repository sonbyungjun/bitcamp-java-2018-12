package ch27.b;

public class Test09 {
  
  public static void main(String[] args) throws Exception {
    
    Class<?> clazz = String.class;
    
    Class<?> superClass = clazz.getSuperclass();
    System.out.println(superClass.getName());
  }
}
