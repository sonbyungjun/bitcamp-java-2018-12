package ch15;

public class Test13 {
  public static void main(String[] args) {
    String obj1 = new String();
    
    Class classInfo = obj1.getClass();
    System.out.println(classInfo.getName());
    
    String[] obj2 = new String[10];
    
    classInfo = obj2.getClass();
    System.out.println(classInfo.getName());
    
    int[] obj3 = new int[10];
    classInfo = obj3.getClass();
    System.out.println(classInfo.getName());
    
    float[] obj4 = new float[10];
    classInfo = obj4.getClass();
    System.out.println(classInfo.getName());
    
    double[] obj5 = new double[10];
    classInfo = obj5.getClass();
    System.out.println(classInfo.getName());
  }
}
