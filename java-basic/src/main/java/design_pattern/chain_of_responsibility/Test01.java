package design_pattern.chain_of_responsibility;

import java.util.Scanner;

public class Test01 {
  
  public static void main(String[] args) {
    Scanner keyScan = new Scanner(System.in);
    
    TerminalHandler terminalHandler = new TerminalHandler();
    PlusHandler plusHandler = new PlusHandler();
    plusHandler.setNext(terminalHandler);
    
    MinusHandler minusHandler = new MinusHandler();
    minusHandler.setNext(plusHandler);
    
    MultipleHandler multipleHandler = new MultipleHandler();
    multipleHandler.setNext(minusHandler);
    
    while (true) {
      System.out.print("a? ");
      int a = keyScan.nextInt();
      
      System.out.print("b? ");
      int b = keyScan.nextInt();
      
      System.out.print("연산자? ");
      String op = keyScan.next();
      
      multipleHandler.handle(a, b, op);
      
    }
    
  }
  
}
