package bitcamp.app1;

import java.beans.PropertyEditorSupport;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.InitBinder;

@ControllerAdvice
public class GlobalControllerAdvice {

  @InitBinder
  public void initBinder(WebDataBinder binder) {
    DatePropertyEditor propEditor = new DatePropertyEditor();
    binder.registerCustomEditor(java.util.Date.class, propEditor);
    
    CarPropertyEditor propEditor2 = new CarPropertyEditor();
    binder.registerCustomEditor(Car.class, propEditor2);
    
    EnginePropertyEditor propEditor3 = new EnginePropertyEditor();
    binder.registerCustomEditor(Engine.class, propEditor3);
  }
  
  
  class EnginePropertyEditor extends PropertyEditorSupport {
    
    @Override
    public void setAsText(String text) throws IllegalArgumentException {
      
      String[] value = text.split(",");
      Engine engine = new Engine();
      engine.setModel(value[0]);
      engine.setCc(Integer.parseInt(value[1]));
      engine.setValve(Integer.parseInt(value[2]));
      setValue(engine);
      
    }
  }
  
  
  class CarPropertyEditor extends PropertyEditorSupport {
    
    @Override
    public void setAsText(String text) throws IllegalArgumentException {
      
      Car car = new Car();
      String[] value = text.split(",");
      car.setModel(value[0]);
      car.setCapacity(Integer.parseInt(value[1]));
      car.setAuto(Boolean.parseBoolean(value[2]));
      car.setCreatedDate(java.sql.Date.valueOf(value[3]));
      setValue(car);
      
    }
  }

  
  class DatePropertyEditor extends PropertyEditorSupport {
    
    SimpleDateFormat format;
    
    public DatePropertyEditor() {
      format = new SimpleDateFormat("yyyy-MM-dd");
    }
    
    @Override
    public void setAsText(String text) throws IllegalArgumentException {
      System.out.println("DatePropertyEditor.setAsText()");
      try {
        Date date = format.parse(text);
        setValue(date);
      } catch (ParseException e) {
        throw new IllegalArgumentException(e);
      }
    }
  }
  
  
}
