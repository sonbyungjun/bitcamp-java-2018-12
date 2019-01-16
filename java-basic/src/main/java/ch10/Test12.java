package ch10;

class Monitor10 {
  int bright;
  int contrast = 50;
  int widthRes;
  int heightRes = 1080;

  Monitor10() {
    this(50, 50, 2560, 1200);
    System.out.println("Monitor10()");
  }

  Monitor10(int bright, int contrast) {
    this(bright, contrast,0 ,0);
    System.out.println("Monitor10(int, int)");
  }
  
  Monitor10(int bright, int contrast, int widthRes, int heightRes) {
    this.bright = bright;
    this.contrast = contrast;
    this.widthRes = widthRes;
    this.heightRes = heightRes;
    System.out.println("Monitor10(int, int, int, int)");
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

public class Test12 {
  public static void main(String[] args) {
    new Monitor10();
    System.out.println("-----------------------------------");
    new Monitor10(50, 50);
    System.out.println("-----------------------------------");
    new Monitor10(50, 50, 1920, 1080);
    
    Monitor10 obj1 = new Monitor10();
//    obj1.Monitor10();
  }
}
