package ch29.j;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import ch29.j2.sub1.Sub1Car;

@ComponentScan(basePackages="ch29.j2")
public class AppConfig4 {
  
  @Bean
  public BlackBox blackBox() {
    BlackBox obj = new BlackBox();
    obj.setMaker("비트박스");
    obj.setModel("비트비트");
    return obj;
  }
  
  @Bean
  public Car car1(Sub1Car sub1Car) {
    Car obj = new Car();
    obj.setMaker("비트자동차");
    obj.setModel("모델1");
    obj.setAuto(true);
    obj.setBlackBox(sub1Car.getBlackBox());
    return obj;
  }
  
  @Bean
  public Car car2(ApplicationContext iocContainer) {
    BlackBox bb = (BlackBox) iocContainer.getBean("blackBox");
    Car obj = new Car();
    obj.setMaker("비트자동차");
    obj.setModel("모델1");
    obj.setAuto(true);
    obj.setBlackBox(bb);
    return obj;
  }
}
