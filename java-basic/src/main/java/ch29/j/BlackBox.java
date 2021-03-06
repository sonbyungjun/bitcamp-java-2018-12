package ch29.j;

import org.springframework.stereotype.Component;

@Component
public class BlackBox {
  private String maker;
  private String model;
  
  public BlackBox() {
    System.out.println("BlackBox()");
  }
  
  public String getMaker() {
    return maker;
  }
  public void setMaker(String maker) {
    this.maker = maker;
  }
  public String getModel() {
    return model;
  }
  public void setModel(String model) {
    this.model = model;
  }
  @Override
  public String toString() {
    return "BlackBox [maker=" + maker + ", model=" + model + "]";
  }
  
  
}
