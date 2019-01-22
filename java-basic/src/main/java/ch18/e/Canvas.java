package ch18.e;

public class Canvas {
  Pen tool;
  //Monami tool;
  
  public Canvas(Pen tool) {
    this.tool = tool;
  }
  
  public void setPen(Pen tool) {
    this.tool = tool;
  }
  
  public void render(String contents) {
    tool.write(contents);
  }
}
