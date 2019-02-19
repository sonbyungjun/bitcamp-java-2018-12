package ch24.b;

public class Test02 {
  
  public static void main(String[] args) {
    
    Thread currThread = Thread.currentThread();
    ThreadGroup group = currThread.getThreadGroup(); 
    System.out.printf("스레드 그룹명: %s\n",group.getName());
    
  }

}
