package ch20.c;

import java.util.HashSet;
import java.util.Iterator;

public class Test01 {
  public static void main(String[] args) {
    HashSet<String> set = new HashSet<>();
    set.add("aaa");
    set.add("bbb");
    set.add("ccc");
    
    set.add("ccc");
    set.add("bbb");
    set.add(null);
    
    set.add(null);
    
    
    Iterator<String> iterator = set.iterator();
    
    while (iterator.hasNext()) {
      System.out.println(iterator.next());
    }
    System.out.println("-------------------------------");
    
    Object[] values = set.toArray();
    
    for (Object value : values) {
      System.out.println(value);
    }
    System.out.println("-------------------------------");
    
    String[] temp = new String[0];
    String[] values2 = set.toArray(temp); 
    System.out.println(temp == values2);
    System.out.println("-------------------------------");
    
    for (String value : values2) {
      System.out.println(value);
    }
    System.out.println("-------------------------------");
    
    String[] values3 = new String[set.size()];
    String[] values4 = set.toArray(values3); 
    System.out.println(values3 == values4);
    System.out.println("-------------------------------");
    for (String value : values3) {
      System.out.println(value);
    }
    
  }
}
