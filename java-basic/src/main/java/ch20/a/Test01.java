package ch20.a;

import java.util.ArrayList;
import java.util.Date;

public class Test01 {
  public static void main(String[] args) {
    ArrayList list = new ArrayList();
    list.add("hello");
    list.add(Integer.valueOf(100));
    list.add(100);
    list.add(new Date());
    
    ArrayList<Object> list2 = new ArrayList<>();
    list2.add("hello");
    list2.add(Integer.valueOf(100));
    list2.add(100);
    list2.add(new Date());
    
    
    
  }
}
