package com.eomcs.lms.handler;

import java.net.URLDecoder;
import java.util.HashMap;

public class ServletRequest {
  
  HashMap<String,String> paramMap = new HashMap<>();
  
  public void setQueryString(String qs) {
    String[] params = qs.split("&");
    for (String param : params) {
      String[] values = param.split("=");
      try {
      paramMap.put(values[0], URLDecoder.decode(values[1], "UTF-8"));
      } catch(Exception e) {}
    }
  }
  
  public String getParameter(String name) {
    return paramMap.get(name);
  }
  
}
