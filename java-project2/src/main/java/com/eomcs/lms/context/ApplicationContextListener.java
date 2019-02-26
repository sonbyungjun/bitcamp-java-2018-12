package com.eomcs.lms.context;

import java.util.Map;

public interface ApplicationContextListener {
  void contextInitialized(Map<String, Object> context) throws ApplicationContextException;
  void contextDestroyed(Map<String, Object> context) throws ApplicationContextException;
}
