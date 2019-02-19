package ch24.c;

public class Test04 {

  @SuppressWarnings("static-access")
  public static void main(String[] args) throws Exception {

    Thread t = new Thread() {
      @Override
      public void run() {
        for (int i = 0; i < 1000; i++) {
          System.out.printf("스레드 ===> %d\n", i);
        }
      }
    };
    t.start();
    
    new Thread(new Runnable() {
      @Override
      public void run() {
        for (int i = 0; i < 1000; i++) {
          System.out.printf("스레드2 >>>>>>>>>>>>>>>>>> %d\n", i);
        }
      }
    }).start();
    
    Thread.currentThread().sleep(5000);
    
    //t.start();
    
    for (int i = 0; i < 1000; i++) {
      System.out.printf("main() ~~~> %d\n", i);
    }
    
  }

}
