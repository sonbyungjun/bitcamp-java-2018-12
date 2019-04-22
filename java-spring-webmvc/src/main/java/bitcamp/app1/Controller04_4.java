package bitcamp.app1;

import java.beans.PropertyEditorSupport;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/c04_4")
public class Controller04_4 {

  // http://localhost:8080/java-spring-webmvc/app1/c04_4/h1?model=sonata&capacity=5&auto=true&createdDate=2019-4-19
  
  @GetMapping("h1")
  @ResponseBody
  public void handler1(
      PrintWriter out,
      String model,
      int capacity,
      boolean auto,
      Date createdDate) {
    
    out.printf("model=%s\n", model);
    out.printf("capacity=%s\n", capacity);
    out.printf("auto=%s\n", auto);
    out.printf("createdDate=%s\n", createdDate);
    
  }
  
  // http://localhost:8080/java-spring-webmvc/app1/c04_4/h2?car=sonata,5,true,2019-4-19
  
  @GetMapping("h2")
  @ResponseBody
  public void handler2(
      PrintWriter out,
      @RequestParam("car") Car car) {
    out.println(car);
  }
  
  // http://localhost:8080/java-spring-webmvc/app1/c04_4/h3?engine=bitengine,3500,16
  
  @GetMapping("h3")
  @ResponseBody
  public void handler3(
      PrintWriter out,
      @RequestParam("engine") Engine engine) {
    out.println(engine);
  }
  
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
    
    public DatePropertyEditor(SimpleDateFormat format) {
      this.format = format;
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
    
    @Override
    public Object getValue() {
      System.out.println("DatePropertyEditor.getValue()");
      return super.getValue();
    }
  }
  
}
