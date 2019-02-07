// 예외 던지기 - 예외를 보고하지 않는 경우
package ch21.e;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Scanner;

public class Test04 {

  
  public static void main(String[] args) throws Exception {
    Scanner keyboard = null;
    
    try {
      keyboard = new Scanner(System.in);
      System.out.print("값? ");
      int a = Integer.parseInt(keyboard.nextLine());
      
      int result = sum(a);
      System.out.println(result);
    } catch (Exception e) {
      StringWriter out = new StringWriter();
      PrintWriter out2 = new PrintWriter(out);
      e.printStackTrace(out2);
      out2.close();
      out.close();
      
      String str = out.toString();
      System.out.println(str);
    } finally {
      keyboard.close();
    }

  }

  static int sum(int value) {
    if (value == 1)
      return 1;
    return value + sum(value -1);
  }

}






