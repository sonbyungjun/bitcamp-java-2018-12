package ch05;

public class Test10 {
  public static void main(String[] args) {
    int a = 1;

    while (a <= 10) { 
      int b = 1;
      while (b <= a) {
        System.out.print(b++ + " ");
      }
      System.out.println();
      a++;
    }

    System.out.println("----------------------------");

    a = 1;
    while (a <= 10) { 
      int b = 1;
      while (b <= a) {
        System.out.print(b++ + " ");
        if (b > 5)
          break;
      }
      System.out.println();
      a++;
    }

    System.out.println("---------------------------");

    a = 1;
    okok:
      while (a <= 10) { 
        int b = 1;
        while (b <= a) {
          System.out.print(b++ + " ");
          if (b > 5)
            break okok;
        }
        System.out.println();
        a++;
      }

    System.out.println("프로그램 종료");

  }
}