package ch29.g;

import java.beans.PropertyEditorSupport;

public class MyCustomBlackBoxEditor extends PropertyEditorSupport {
  
  @Override
  public void setAsText(String text) throws IllegalArgumentException {
    System.out.printf("MyCustomBlackBoxEditor.setAsText(%s)\n", text);
    BlackBox b = new BlackBox();
    String[] i = text.split(",");
    b.setMaker(i[0]);
    b.setModel(i[1]);
    this.setValue(b);
  }
  
}