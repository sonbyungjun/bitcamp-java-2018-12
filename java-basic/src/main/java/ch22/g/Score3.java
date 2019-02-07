package ch22.g;

import java.io.Serializable;

public class Score3 implements Serializable {
  private static final long serialVersionUID = 1L;
  
  private String name;
  private int kor;
  private int eng;
  private int math;
  
  transient private int sum;
  transient private float aver;
  
  public Score3() {
    System.out.println("Score3()");
  }

  @Override
  public String toString() {
    return "Score3 [name=" + name + ", kor=" + kor + ", eng=" + eng + ", math=" + math + ", sum="
        + sum + ", aver=" + aver + "]";
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    System.out.println("setName()");
    this.name = name;
    compute();
  }

  public int getKor() {
    return kor;
  }

  public void setKor(int kor) {
    System.out.println("setKor()");
    this.kor = kor;
    compute();
  }

  public int getEng() {
    return eng;
  }

  public void setEng(int eng) {
    System.out.println("setEng()");
    this.eng = eng;
    compute();
  }

  public int getMath() {
    return math;
  }

  public void setMath(int math) {
    System.out.println("setMath()");
    this.math = math;
    compute();
  }

  public int getSum() {
    return sum;
  }

  public float getAver() {
    return aver;
  }
  
  public void compute() {
    this.sum = this.kor + this.eng + this.math;
    this.aver = this.sum / 3f;
  }
  
  
}
