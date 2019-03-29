package com.eomcs.lms;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;

@ComponentScan(basePackages="com.eomcs.lms")
@ImportResource("classpath:/com/eomcs/lms/conf/tx-context.xml")
public class AppConfig {
  
}
