package ch24.b;

public class Test05 {
  
  public static void main(String[] args) {
    
    Thread currThread = Thread.currentThread();
    ThreadGroup group = currThread.getThreadGroup();
    ThreadGroup parentGroup = group.getParent();
    System.out.println(parentGroup.getName() + "(TG)");
    
    ThreadGroup parentparentGroup = parentGroup.getParent();
    System.out.println(parentparentGroup);
  }

}
