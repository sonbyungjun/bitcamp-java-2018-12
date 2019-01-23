package design_pattern.abstract_factory;

public abstract class Unit {
  
  public static final int GENERAL_BUILDING = 0;
  public static final int DEFENCE_BUILDING = 1;
  public static final int ATTACK_BUILDING = 2;
  
  protected String name;
  protected int area;
  protected int type;
  
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getArea() {
    return area;
  }

  public void setArea(int area) {
    this.area = area;
  }

  public int getType() {
    return type;
  }

  public void setType(int type) {
    this.type = type;
  }

  public void build() {
    prepare();
    construct();
    install();
    interio();
  }
  
  public abstract void prepare();
  public abstract void construct();
  public abstract void install();
  public abstract void interio();
  
}
