package com.eomcs.lms.context;

import java.lang.reflect.Method;
import java.util.HashMap;

public class RequestMappingHandlerMapping {
  
  HashMap<String, RequestMappingHandler> handlerMappings = new HashMap<>();
  
  public void add(String name, RequestMappingHandler handler) {
    handlerMappings.put(name, handler);
  }
  
  public RequestMappingHandler get(String name) {
    return handlerMappings.get(name);
  }
  
  
  public static class RequestMappingHandler {
    
    public Object bean;
    public Method method;
    
    public RequestMappingHandler(Object bean, Method method) {
      this.bean = bean;
      this.method = method;
    }
  }
}
