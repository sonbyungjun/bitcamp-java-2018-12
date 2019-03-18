package ch29.a;

import org.springframework.context.annotation.Bean;

public class AppConfig02 {
  
  @Bean public Student b1() {
    return new Student();
  }
  
}
