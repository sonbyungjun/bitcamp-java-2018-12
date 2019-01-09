package ch05;

public class Test13 {
  public static void main(String[] args) {
    for (int i = 1, j = 3, k = 5; i <= 10; i++, j--, k += 2) 
      System.out.printf("(%d, %d, %d) ", i, j, k);
    System.out.println();

    for (int i = 1; i <= 10; i++) {
      for (int j = 1; j <= i; j++) {
        System.out.print(j + " ");
      }
      System.out.println();
    }
    System.out.println("----------------------------------");

    for (int i = 1; i <= 10; i++) {
      for (int j = 1; j <= i; j++) {
        System.out.print(j + " ");
        if (j == 5) {
          break;
        }
      }
      System.out.println();
    }
    System.out.println("----------------------------------");

    loop1: {
      for (int i = 1; i <= 10; i++) {
        for (int j = 1; j <= i; j++) {
          System.out.print(j + " ");
          if (j == 5) {
            break loop1;
          }
        }
        System.out.println();
      }
      System.out.println("----------------------------------");
    }
    
    for (int i = 1; i <= 10; i++) {
      for (int j = 1; j <= i; j++) {
        if (j % 2 == 0) {
          continue;
        }
        System.out.print(j + " ");
      }
      System.out.println();
    }
    System.out.println("----------------------------------");
    
    for (int i = 1; i <= 10; i += 2) {
      for (int j = 1; j <= i; j++) {
        if (j % 2 == 0) {
          continue;
        }
        System.out.print(j + " ");
      }
      System.out.println();
    }
    System.out.println("----------------------------------");
    
    for (int i = 0; i <=10; i += 2) {
      for (int j = 1; j <= i; j++) {
        if (j % 2 == 1) {
          System.out.print(j);          
        }
      }
      System.out.println();
    }
  }
}
