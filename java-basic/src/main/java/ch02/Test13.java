package ch02;

import java.util.Date;

public class Test13 {
  public static void main(String[] args) {
    Date today = new Date();
    System.out.printf("%1$tY, %1$ty\n" , today);
    System.out.printf("%1$tB, %1$tb\n" , today);
    System.out.printf("%1$tm\n" , today);
    System.out.printf("%1$td, %1$te\n" , today);
    System.out.printf("%1$tA, %1$ta\n" , today);
    System.out.printf("%1$tH, %1$tI\n" , today);
    System.out.printf("%1$tM\n" , today);
    System.out.printf("%1$tS, %1$tL, %1$tN\n" , today);
    System.out.printf("%1$tp\n" , today);
    
    System.out.printf("%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS\n", today);
  }
}
