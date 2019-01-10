package ch06;

public class Test17 {
  public static void main(String[] args) {
    String name = System.getProperty("name");
    int kor = Integer.parseInt(System.getProperty("kor"));
    int eng = Integer.parseInt(System.getProperty("kor"));
    int math = Integer.parseInt(System.getProperty("kor"));
    int sum = kor + eng + math;
    
    System.out.printf("이름 : %s\n", name);
    System.out.printf("총점 : %d\n", sum);
    System.out.printf("평균 : %.1f\n", sum / 3f);
  }
}