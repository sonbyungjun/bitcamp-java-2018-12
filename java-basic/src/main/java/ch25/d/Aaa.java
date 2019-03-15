package ch25.d;

public class Aaa {
  public static void main(String[] args) {
    for (int i = 2; i < 10; i++) {
      for (int j = 1; j < 10; j++) {
        System.out.printf("%d * %d = %d\n", i, j, i*j);
      }
      System.out.println();
    }
    
  }
}
