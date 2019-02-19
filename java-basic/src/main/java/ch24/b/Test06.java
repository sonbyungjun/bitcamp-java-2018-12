package ch24.b;

public class Test06 {
  
  public static void main(String[] args) {
    
    Thread mainThread = Thread.currentThread();
    ThreadGroup maingroup = mainThread.getThreadGroup();
    ThreadGroup systemGroup = maingroup.getParent();
    
    printThreads(systemGroup, "");
  }
  
  static void printThreads(ThreadGroup tg, String indent) {
    System.out.println(indent + tg.getName() + "(TG)");
    
    Thread[] threads = new Thread[10];
    int size = tg.enumerate(threads, false);
    for (int i = 0; i < size; i++) {
      System.out.println(indent + "  ==> " + threads[i].getName() + "(T)");
    }
    
    ThreadGroup[] groups = new ThreadGroup[10];
    size = tg.enumerate(groups, false);
    for (int i = 0; i < size; i++) {
      printThreads(groups[i], indent + "  ");
    }
  }

}
