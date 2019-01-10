package ch07;

public class Test07 {

  static class Score {
    String name;
    int kor;
    int eng;
    int math;
    int sum;
    float aver;
  }

  public static void main(String[] args) {
    String name;
    int kor;
    int eng;
    int math;
    int sum;
    float aver;
    
//    System.out.println(name);
    
    Score s = new Score();
    
    System.out.println(s.name);
    System.out.println(s.kor);
    System.out.println(s.aver);
    
  }
}