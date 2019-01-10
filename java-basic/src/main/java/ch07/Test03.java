package ch07;

public class Test03 {
  
  static class Score {
    String name;
    int kor;
    int eng;
    int math;
    int sum;
    float aver;
  }
  
  public static void main(String[] args) {
    Score s1;
    s1 = new  Score();

    Score s2 = new Score();

    s1.name = "홍길동";
    s1.kor = 100;
    s1.eng = 100;
    s1.math = 100;


    s2.name = "임꺽정";
    s2.kor = 90;
    s2.eng = 90;
    s2.math = 90;

    pringScore(s1);
    pringScore(s2);
  }

  static void pringScore(Score s) {
    s.sum = s.kor + s.eng + s.math;
    s.aver = s.sum / 3f;
    System.out.printf("%s : %d, %d, %d, %d, %f\n", s.name, s.kor, s.eng, s.math, s.sum, s.aver);
  }

}
