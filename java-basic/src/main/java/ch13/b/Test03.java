package ch13.b;

public class Test03 {
  public static void main(String[] args) {
    Score3 s = new Score3();
    s.setName("홍길동");
    s.setKor(100);
    s.setEng(100);
    s.setMath(100);
    s.setMusic(100);
    s.setArt(100);
    System.out.printf("%s : %d(%.1f)\n", s.getName(), s.getSum(), s.getAver());
  }
}
