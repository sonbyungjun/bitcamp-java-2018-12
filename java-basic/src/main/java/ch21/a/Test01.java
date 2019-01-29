package ch21.a;

public class Test01 {
  public static void main(String[] args) {
    
    //System.out.println(sum(100000));
    
    int result = 100 / 0;
    
    System.out.println("실행 완료");
  }
  
  static long sum(long value) {
    if (value == 0)
      return 0;
    return value + sum(value -1);
  }
  
}
