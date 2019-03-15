package com.eomcs.lms.context;

import java.io.File;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.apache.ibatis.io.Resources;
import com.eomcs.lms.handler.Command;

public class ApplicationContext {
  
  ArrayList<Class<?>> classes = new ArrayList<>();
  
  HashMap<String, Object> beans = new HashMap<>();
  
  public ApplicationContext(String packageName, Map<String, Object> beans) throws Exception {
    
    if (beans != null && beans.size() > 0) {
      Set<String> names = beans.keySet();
      for (String name : names) {
        addBean(name, beans.get(name));
      }
    }
    File packageDir = Resources.getResourceAsFile(packageName.replace(".", "/"));
    findClasses(packageDir, packageName);
    prepareCommand();
  }
  
  private void addBean(String name, Object bean) {
    if (name == null || name.length() == 0 || bean == null) {
      return;
    }
    beans.put(name, bean);
  }

  private void findClasses(File dir, String packageName) throws Exception {
    
    File[] files = dir.listFiles((File pathname) -> {
        if (pathname.isDirectory())
          return true;
        if (pathname.getName().endsWith(".class") &&
            !pathname.getName().contains("$"))
          return true;
        return false;
      });
    
    for (File f : files) {
      if(f.isFile()) {
        String filename = f.getName();
        String className = packageName + "." + 
            filename.substring(0, filename.indexOf('.'));
        Class<?> clazz = Class.forName(className);
        if (clazz.isLocalClass() || clazz.isInterface() || clazz.isEnum())
          continue;
        if(Modifier.isAbstract(clazz.getModifiers()) ||
            !Modifier.isPublic(clazz.getModifiers()))
          continue;
        classes.add(clazz);
      } else {
        findClasses(f, packageName + "." + f.getName());
      }
    }
  }
  
  private void prepareCommand() throws Exception {
    for (Class<?> clazz : classes) {
//      System.out.println("필터에걸러낸 클래스정보목록 : " +clazz.getName());
      //System.out.println("getAllInterFaces 호출 : " +clazz.getName());
      List<Class<?>> interfaces = getAllInterFaces(clazz);
      for (Class<?> i : interfaces) {
        //System.out.println("        " + i.getName());
        if (i == Command.class) {
          
          break;
        }
      }
    }
  }
  
  private List<Class<?>> getAllInterFaces(Class<?> clazz) {
    ArrayList<Class<?>> list = new ArrayList<>();
    while (clazz != Object.class) {
      //System.out.println("    " + clazz.getName());
      Class<?>[] interfaces = clazz.getInterfaces();
      for (Class<?> i : interfaces) {
        list.add(i);
      }
      clazz = clazz.getSuperclass();
    }
    return list;
  }
}
