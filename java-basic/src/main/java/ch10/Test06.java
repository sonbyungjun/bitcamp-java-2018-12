package ch10;

class Monitor4 {
  int bright;
  int contrast;
  int widthRes;
  int heightRes;
  
  Monitor4() {
    this.bright = 50;
    this.contrast = 50;
    this.widthRes = 1920;
    this.heightRes = 1080;
  }
  
  void display() {
    System.out.println("------------------------------");
    System.out.printf("밝기(%d)\n", this.bright);
    System.out.printf("명암(%d)\n", this.contrast);
    System.out.printf("해상도(%d x %d)\n", this.widthRes, this.heightRes);
    System.out.println("------------------------------");
  }
}

public class Test06 {
  public static void main(String[] args) {
    Monitor4 m1 = new Monitor4();

    m1.display();
    
    m1.bright = 40;

    m1.display();
  }
}
