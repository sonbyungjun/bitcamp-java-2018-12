package ch10;

class Monitor2 {
  int bright = 50;
  int contrast = 50;
  int widthRes = 1920;
  int heightRes = 1080;
  
  void display() {
    System.out.println("------------------------------");
    System.out.printf("밝기(%d)\n", this.bright);
    System.out.printf("명암(%d)\n", this.contrast);
    System.out.printf("해상도(%d x %d)\n", this.widthRes, this.heightRes);
    System.out.println("------------------------------");
  }
}

public class Test04 {
  public static void main(String[] args) {
    Monitor2 m1 = new Monitor2();

    m1.display();
    
    m1.bright = 0;

    m1.display();
  }
}
