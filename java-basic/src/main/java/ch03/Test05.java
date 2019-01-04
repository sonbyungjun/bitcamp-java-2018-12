package ch03;

import java.util.Date;

public class Test05 {
  public static void main(String[] args) {
    Date d1 = new Date();
    Date d2 = d1;
    
    System.out.println(d1.getMonth());
    System.out.printf("%d, %d\n",d1.getDay(), d2.getDay());
    
    d1.setDate(10);
    
    System.out.printf("%d, %d\n",d1.getDay(), d2.getDay());
  }
}
