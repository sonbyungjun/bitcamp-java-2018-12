package ch16;

import java.io.File;
import java.util.Calendar;
import java.util.Date;

public class Test03 {
  public static void main(String[] args) {
    
    String obj1 = echo(new String("Hello"));
    Date obj2 = echo(new Date());
    Calendar obj3 = echo(Calendar.getInstance());
    File obj4 = echo(new File("okok"));
    Integer obj5 = echo(Integer.valueOf(100));
  }
  
  public static <Ok> Ok echo(Ok obj) {
    return obj;
  }
  
}
