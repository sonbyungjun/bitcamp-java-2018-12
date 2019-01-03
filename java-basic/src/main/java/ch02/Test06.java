package ch02;

public class Test06 {
  static final float f = 12.375f;
  public static void main(String[] args) {
    System.out.println(0.1f*0.1f == 0.01f);
    System.out.println((0.1f*0.1f - 0.01f) <= Float.POSITIVE_INFINITY);
  }
}
