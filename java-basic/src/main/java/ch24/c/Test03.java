package ch24.c;

public class Test03 {

  public static void main(String[] args) throws Exception {

    Thread t = new Thread() {
      @Override
      public void run() {
        for (int i = 0; i < 1000; i++) {
          System.out.printf("스레드 ===> %d\n", i);
        }
        try {
        sleep(5000);
        } catch (Exception e) {}
      }
    };
    t.start();
    
    t.join();
    
    for (int i = 0; i < 1000; i++) {
      System.out.printf("main() ~~~> %d\n", i);
    }
    
  }

}
