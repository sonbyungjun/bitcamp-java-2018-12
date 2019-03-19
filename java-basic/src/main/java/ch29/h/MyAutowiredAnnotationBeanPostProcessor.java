package ch29.h;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class MyAutowiredAnnotationBeanPostProcessor implements BeanPostProcessor {

  HashMap<Class<?>, Object> beans = new HashMap<>();

  HashMap<Class<?>, List<AutowiredMethod>> autowiredMethodMap = new HashMap<>();

  @Override
  public Object postProcessBeforeInitialization(Object bean, String beanName)
      throws BeansException {

    Method[] methods = bean.getClass().getMethods();

    System.out.println("@Autowired 애노테이션 처리:");
    
    callAutowiredMethod(bean);

    for (Method m : methods) {
      Autowired anno = m.getAnnotation(Autowired.class);

      if (anno == null) 
        continue;

      Class<?> paramType = m.getParameters()[0].getType();
      if (isRegistered(paramType)) {
        try {
          m.invoke(bean, getDependency(paramType));
        } catch (Exception e) {
          e.printStackTrace();
        }
      } else {
        addAutowiredMethod(paramType, new AutowiredMethod(bean, m));
      }
    }
    return bean;
  }


  private void callAutowiredMethod(Object parmaValue) {
    List<AutowiredMethod> setters = autowiredMethodMap.get(parmaValue.getClass());
    if (setters == null)
      return;
    
    for (AutowiredMethod setter : setters) {
      try {
      setter.method.invoke(setter.object, parmaValue);
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
  } 

  private boolean isRegistered(Class<?> type) {
    return beans.get(type) != null ? true : false;
  }
  
  private Object getDependency(Class<?> type) {
    return beans.get(type);
  }
  
  private void addAutowiredMethod(
      Class<?> paramType, AutowiredMethod autowiredMethod) {
    List<AutowiredMethod> methods = autowiredMethodMap.get(paramType);
    if(methods == null) {
      methods = new ArrayList<>();
      autowiredMethodMap.put(paramType, methods);
    }
    
    methods.add(autowiredMethod);
  }

  class AutowiredMethod {
    Object object;
    Method method;

    public AutowiredMethod(Object object, Method method) {
      this.object = object;
      this.method = method;
    }
  }

}

