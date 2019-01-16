package ch12.b;

public class Test01 {

  public static void main(String[] args) {

    Calculrator c = new Calculrator();
    c.plus(100);
    c.plus(15);
    c.minus(27);
    System.out.println(c.getResult());


    Calculrator c2 = new Calculrator();
    c2.plus(100);
    c2.plus(15);
    //    c2.result = 100;
    c2.minus(27);
    System.out.println(c2.getResult());

  }
}
