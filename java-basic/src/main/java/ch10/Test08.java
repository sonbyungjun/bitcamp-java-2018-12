package ch10;

class Monitor6 {
  int bright;
  int contrast = 50;
  int widthRes;
  int heightRes = 1080;
  
  Monitor6() {
    this.contrast = 70;
    this.widthRes = 2560;
    this.heightRes = 1200;
  }
  
  public void on() {
    System.out.println("화면을 출력한다.");
  }
  
  void display() {
    System.out.println("------------------------------");
    System.out.printf("밝기(%d)\n", this.bright);
    System.out.printf("명암(%d)\n", this.contrast);
    System.out.printf("해상도(%d x %d)\n", this.widthRes, this.heightRes);
    System.out.println("------------------------------");
  }
}

public class Test08 {
  public static void main(String[] args) {
//    new Monitor6;
    new Monitor6();
//    new Monitor6(100);
    
  }
}
