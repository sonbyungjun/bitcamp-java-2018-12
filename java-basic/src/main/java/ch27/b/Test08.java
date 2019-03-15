package ch27.b;

public class Test08 {
  
  public static void main(String[] args) throws Exception {
    
    Class<?> clazz = String.class;
    
    Class<?>[] interfaces = clazz.getInterfaces();
    for (Class<?> c : interfaces) {
      System.out.println(c.getName());
    }
  }
}
