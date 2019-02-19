package ch24.b;

public class Test04 {
  
  public static void main(String[] args) {
    
    Thread currThread = Thread.currentThread();
    ThreadGroup group = currThread.getThreadGroup();
    System.out.println("main 스레드 그룹에 소속된 스레드들: ");
    
    System.out.println(group.getName() + "(TG)");
    
    ThreadGroup[] groupList = new ThreadGroup[10];
    int size = 0;
    size = group.enumerate(groupList, false);
    
    for (int i = 0; i < size; i++) {
      System.out.println("  => " + groupList[i].getName() + "(TG)");
    }
    
  }

}
