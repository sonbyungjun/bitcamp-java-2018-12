package ch29.g;

import java.beans.PropertyEditorSupport;
import java.sql.Date;

public class MyCustomDateEditor extends PropertyEditorSupport {
  
  @Override
  public void setAsText(String text) throws IllegalArgumentException {
    System.out.printf("MyCustomDateEditor.setAsText(%s)\n", text);
    Date date = Date.valueOf(text);
    this.setValue(date);
  }
  
}