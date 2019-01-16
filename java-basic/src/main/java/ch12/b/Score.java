package ch12.b;

public class Score {
  String name;
  int kor;
  int eng;
  int math;
  
  private int sum;
  private float aver;
  
  public int getSum() {
    return this.sum;
  }
  
  public float getAver() {
    return this.aver;
  }
  
  void compute() {
    this.sum = this.kor + this.eng + this.math;
    this.aver = this.sum / 3f;
  }
}
