package ch20.a;

import java.util.ArrayList;

public class Test03 {
  public static void main(String[] args) {
    
    String s1 = new String("aaa");
    String s2 = new String("bbb");
    String s3 = new String("ccc");
    String s4 = new String("bbb");
    
    System.out.println(s2 == s4);
    System.out.println(s2.equals(s4));
    System.out.println(s2.hashCode() == s4.hashCode());
    
    ArrayList<String> list = new ArrayList<>();
    list.add(s1);
    list.add(s2);
    list.add(s3);
    
    System.out.println(list);
    
    System.out.println(list.contains(s2));
    System.out.println(list.contains(s4));
  }
}
