package ch24.c;

public class Test01 {
  
  static class MyThread extends Thread {
    @Override
    public void run() {
      for (int i = 0; i < 2000; i++) {
        System.out.printf("MyThread ===> %d\n", i);
      }
    }
  }
  
  static class MyWork implements Runnable {

    @Override
    public void run() {
      for (int i = 0; i < 2000; i++) {
        System.out.printf("MyWork >>>> %d\n", i);
      }
    }
    
  }
  
  
  
  public static void main(String[] args) {
    
    MyThread t1 = new MyThread();
    t1.start();
    
    MyWork w = new MyWork();
    Thread t2 = new Thread(w);
    t2.start();
    
    for (int i = 0; i < 2000; i++) {
      System.out.printf("main ~~~> %d\n", i);
    }
  }

}
