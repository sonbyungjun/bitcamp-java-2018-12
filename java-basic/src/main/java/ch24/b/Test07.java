package ch24.b;

public class Test07 {
  
  public static void main(String[] args) {
    
    Thread mainThread = Thread.currentThread();
    System.out.println(mainThread.getPriority());
    
    System.out.printf("우선순위 범위: %d ~ %d\n", Thread.MIN_PRIORITY, Thread.MAX_PRIORITY);
    
  }

}
