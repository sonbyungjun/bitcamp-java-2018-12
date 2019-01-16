package ch10;

class Monitor1 {
  int bright;
  int contrast;
  int widthRes;
  int heightRes;
  
  void display() {
    System.out.println("------------------------------");
    System.out.printf("밝기(%d)\n", this.bright);
    System.out.printf("명암(%d)\n", this.contrast);
    System.out.printf("해상도(%d x %d)\n", this.widthRes, this.heightRes);
    System.out.println("------------------------------");
  }
}

public class Test03 {
  public static void main(String[] args) {
    Monitor1 m1 = new Monitor1();

    m1.display();
    
    m1.bright = 50;
    m1.contrast = 50;
    m1.widthRes = 1920;
    m1.heightRes =  1080;
    
    m1.display();
    
    
  }
}
