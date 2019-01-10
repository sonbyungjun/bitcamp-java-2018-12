package ch07;

public class Test06 {

  static class Score {
    String name;
    int kor;
    int eng;
    int math;
    int sum;
    float aver;
  }

  public static void main(String[] args) {
    Score s1 = new Score();
    Score s2 = new Score();
    s2 = s1;
    s1 = new Score();
  }
  
}