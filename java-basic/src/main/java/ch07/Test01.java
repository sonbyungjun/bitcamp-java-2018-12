package ch07;

public class Test01 {
  public static void main(String[] args) {
    String name = "홍길동";
    int kor = 100;
    int eng = 100;
    int math = 100;
    int sum = kor + eng + math;
    float aver = sum/ 3f;
    
    System.out.printf("%s : %d, %d, %d, %d, %f\n", name, kor, eng, math, sum, aver);
  }
}
