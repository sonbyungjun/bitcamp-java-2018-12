package ch10;

import java.util.Calendar;

public class Test16 {
  public static void main(String[] args) throws Exception{
    Calendar c1;
//    c1 = new Calender();
    
    c1 = Calendar.getInstance();
       System.out.println(c1.get(Calendar.YEAR));
       System.out.println(c1);
  }
}
