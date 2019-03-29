package com.eomcs.lms.context;

import java.lang.reflect.Method;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;
import com.eomcs.lms.context.RequestMappingHandlerMapping.RequestMappingHandler;

@Component
public class RequestMappingAnnotationBeanPostProcessor implements BeanPostProcessor {

  RequestMappingHandlerMapping handlerMapping;

  public RequestMappingAnnotationBeanPostProcessor(RequestMappingHandlerMapping handlerMapping) {
    this.handlerMapping = handlerMapping;
  }

  @Override
  public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {

    // 각 객체에 대해 @RequestMapping 메서드를 찾는다.
    Method[] methods = bean.getClass().getMethods();
    
    for (Method m : methods) {
      
      RequestMapping requestMapping = m.getAnnotation(RequestMapping.class);
      
      if (requestMapping == null) 
        continue;

      // RequestMapping이 붙은 메서드를 찾았으면 그 정보를 RequestMappingHandler에 담는다.
      RequestMappingHandler handler = new RequestMappingHandler(bean, m);

      // 그리고 이 요청 핸들러(RequestMapping 애노테이션이 붙은 메서드)를 저장한다.
      handlerMapping.add(requestMapping.value(), handler);
      //System.out.println("==> " + requestMapping.value());
    }

    return bean;
  }

}
