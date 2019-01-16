package ch11;

import java.util.Date;

public class Test09 {
  public static void main(String[] args) {
    //    Integer i1 = new Integer(100);
    Integer i1 = Integer.valueOf(100);
    //    char c = new Character('가');
    Character c1 = Character.valueOf('가');
    byte b = i1.byteValue();
    String s = i1.toString();
    String str = Integer.toHexString(200);

    printInt(100);
    printFloat(3.14f);
    //    printInt("Hello");
    Integer x = Integer.valueOf(1000);
    Float y = Float.valueOf(3.14f);
    String z = "Hello";
    Date today = new Date();
    
    printObject(x);
    printObject(y);
    printObject(z);
    printObject(today);
  }

  static void printInt(int i) {
    System.out.println("값 => " + i);
  }

  static void printFloat(float f) {
    System.out.println("값 => " + f);
  }
  
  static void printObject(Object obj) {
    System.out.println("값 => " + obj.toString());
  }
}
