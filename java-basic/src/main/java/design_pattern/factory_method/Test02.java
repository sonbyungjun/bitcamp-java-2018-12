package design_pattern.factory_method;

class Car2 {
  String model;
  int cc;
  boolean sunroof;
}

class Car2Factory {
  public static Car2 create(String product) {
    Car2 c = new Car2();
    switch (product) {
      case "tc":
        c.model = "티코";
        c.cc = 890;
        c.sunroof = false;
        break;
      case "tcg":
        c.model = "티코 골드";
        c.cc = 890;
        c.sunroof = true;
        break;
      case "sn":
        c.model = "소나타";
        c.cc = 1980;
        c.sunroof = false;
        break;
      case "sng":
        c.model = "소나타 골드";
        c.cc = 1980;
        c.sunroof = true;
        break;
      default:
        return null;
    }
    return c;
  }
}

public class Test02 {

  public static void main(String[] args) {
    Car2 c1 = Car2Factory.create("tc");
    Car2 c2 = Car2Factory.create("tcg");
    Car2 c3 = Car2Factory.create("sn");
    Car2 c4 = Car2Factory.create("sng");
    Car2 c5 = Car2Factory.create("okok");
    
    System.out.println(c1.model);
    System.out.println(c2.model);
    System.out.println(c3.model);
    System.out.println(c4.model);
    System.out.println(c5.model);
  }

}
