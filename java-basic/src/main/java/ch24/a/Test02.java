package ch24.a;

public class Test02 {
  
  static class MyThread extends Thread {
    @Override
    public void run() {
      for (int i = 0; i < 1000; i++) {
        System.out.println("====> " + i);
      }
    }
  }
  
  public static void main(String[] args) {
    
    MyThread t = new MyThread();
    t.start();
  
   for (int i = 0; i < 1000; i++) {
     System.out.println(">>>>> " + i);
   }
   
  }

}
