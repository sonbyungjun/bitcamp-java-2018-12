package ch06;

public class Test14 {
  public static void main(String[] args) {
    int sum = 0;
    for (String arg : args) {
      sum += Integer.parseInt(arg);
    }
    System.out.printf("합계 : %d\n",sum);
  }
}