package ch20.a;

import java.util.ArrayList;

public class Test02 {
  public static void main(String[] args) {
    ArrayList<String> list = new ArrayList<>();
    list.add("aaa");
    list.add("bbb");
    list.add("ccc");
    list.add("ddd");
    list.add(null);
    list.add("eee");
    list.add(null);
    list.add("aaa");
    list.add("bbb");
    
    
    System.out.println(list);
    
    String s = list.remove(2);
    System.out.println(list);
    System.out.println(s);
    
    list.set(2, "xxx");
    System.out.println(list);
    
    System.out.println(list.get(2));
    
    System.out.println(list.get(3));
  }
}
