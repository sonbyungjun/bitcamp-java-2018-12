package ch29.h;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class MyBeanPostProcessor implements BeanPostProcessor {
  
  @Override
  public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
    System.out.println("MyBeanPostProcessor.postProcessAfterInitialization()");
    System.out.printf("    => %s : %s\n", beanName, bean.toString());
    return bean;
  }
  
  @Override
  public Object postProcessBeforeInitialization(Object bean, String beanName)
      throws BeansException {
    System.out.println("MyBeanPostProcessor.postProcessBeforeInitialization()");
    System.out.printf("    => %s : %s\n", beanName, bean.toString());
    return bean;
  }
}
