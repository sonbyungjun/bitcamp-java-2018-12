package com.eomcs.lms.handler;

import java.util.HashMap;

public class ServletRequest {
  
  HashMap<String,String> paramMap = new HashMap<>();
  
  public void setQueryString(String qs) {
    String[] params = qs.split("&");
    for (String param : params) {
      String[] values = param.split("=");
      paramMap.put(values[0], values[1]);
    }
  }
  
  public String getParameter(String name) {
    return paramMap.get(name);
  }
  
}
