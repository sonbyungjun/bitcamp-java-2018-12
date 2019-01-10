package ch07;

class Score1 {
  String name;
  int kor;
  int eng;
  int math;
  int sum;
  float aver;
}

public class Test09 {

  static class Score2 {
    String name;
    int kor;
    int eng;
    int math;
    int sum;
    float aver;
  }

  class Score3 {
    String name;
    int kor;
    int eng;
    int math;
    int sum;
    float aver;
  }

  public static void main(String[] args) {

    class Score4 {
      String name;
      int kor;
      int eng;
      int math;
      int sum;
      float aver;
    }

    Object obj = new Object() {
      String name;
      int age;
    };

  }

  static void m1() {
    Score1 s1 = new Score1();
    Score2 s2 = new Score2();
    //    Score3 s3 = new Score3();
    //    Score4 s4 = new Score4();
  }

  void m2() {
    Score1 s1 = new Score1();
    Score2 s2 = new Score2();
    Score3 s3 = new Score3();
    //    Score4 s4 = new Score4();
  }

}

