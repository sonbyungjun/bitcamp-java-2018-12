package ch16;

import java.util.Calendar;
import java.util.Date;

public class Test01 {
  public static void main(String[] args) {
    
//    String obj = echo(new String("Hello"));
    String obj = (String) echo(new String("Hello"));
    
    Integer obj2 = (Integer) echo(new String("Hello"));
    
    Date obj3 = (Date) echo(new Date());
    
    Calendar obj4 = (Calendar) echo(Calendar.getInstance());
  }
  
  public static Object echo(Object obj) {
    return obj;
  }
}
