package com.eomcs.lms.context;

import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import org.apache.ibatis.io.Resources;
import com.eomcs.lms.context.RequestMappingHandlerMapping.RequestMappingHandler;

public class ApplicationContext {

  ArrayList<Class<?>> classes = new ArrayList<>();

  HashMap<String, Object> beanContainer = new HashMap<>();

  public ApplicationContext(Class<?> configClass) throws Exception {

    Constructor<?> c = configClass.getConstructor();
    Object config = c.newInstance();

    ArrayList<Method> factoryMethods = new ArrayList<>();
    Method[] methods = configClass.getMethods();
    for (Method m : methods) {
      if (m.getAnnotation(Bean.class) != null)
        factoryMethods.add(m);
    }

    while (factoryMethods.size() > 0) {
      Method m = factoryMethods.get(0);
      callFactoryMethod(config, m, factoryMethods, "");
      factoryMethods.remove(m);
    }

    ComponentScan componentScan = configClass.getAnnotation(ComponentScan.class);
    if (componentScan != null) {
      String[] packages = componentScan.basePackages();
      for (String packageName : packages) {
        prepareComponent(packageName);
      }
    }

  }

  public void prepareComponent(String packageName) throws Exception {

    File packageDir = Resources.getResourceAsFile(packageName.replace(".", "/"));
    findClasses(packageDir, packageName);
    prepareComponent();
    postProcess();

    System.out.println("----------------------------------------");
    Set<String> names = beanContainer.keySet();
    for (String name : names) {
      System.out.printf("%s : %s\n", name, beanContainer.get(name).getClass().getSimpleName());
    }
  }

  private void addBean(String name, Object bean) {
    if (name == null || name.length() == 0 || bean == null) 
      return;
    beanContainer.put(name, bean);
  }

  public Object getBean(String name) {
    return beanContainer.get(name);
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

  private void prepareComponent() throws Exception {
    for (Class<?> clazz : classes) {
      Component compAnno = clazz.getAnnotation(Component.class);

      if (compAnno == null) 
        continue;

      Object obj = createInstance(clazz);

      if (obj != null) {
        addBean(
            compAnno.value().length() > 0 ? compAnno.value() : clazz.getName(),
                obj);
      }
    }
  }

  private Object createInstance(Class<?> clazz) throws Exception {
    try {
      Constructor<?> defaultConstructor = clazz.getConstructor();
      return defaultConstructor.newInstance();
    } catch(Exception e) {
    }
    Constructor<?>[] constructors = clazz.getConstructors();
    for (Constructor<?> c : constructors) {
      Class<?>[] paramTypes = c.getParameterTypes();
      Object[] paramValues = getParameterValues(paramTypes);
      if (paramValues != null) {
        return c.newInstance(paramValues);
      }
    }
    return null;
  }

  private Object[] getParameterValues(Class<?>[] paramTypes) {
    ArrayList<Object> values = new ArrayList<>();
    for (Class<?> type : paramTypes) {
      Object value = findBean(type);
      if (value != null) {
        values.add(value);
      }
    }
    if (values.size() == paramTypes.length)
      return values.toArray();
    else
      return null;
  }

  private Object findBean(Class<?> type) {
    Collection<Object> beans = beanContainer.values();
    for (Object bean : beans) {
      if (type.isInstance(bean))
        return bean;
    }
    return null;
  }

  public void postProcess() {
    RequestMappingHandlerMapping handlerMapping = new RequestMappingHandlerMapping();

    Collection<Object> beans = beanContainer.values();

    for (Object bean : beans) {
      Method[] methods = bean.getClass().getMethods();
      for (Method m : methods) {
        RequestMapping requestMapping = m.getAnnotation(RequestMapping.class);
        if (requestMapping == null)
          continue;
        RequestMappingHandler handler = new RequestMappingHandler(bean, m);
        handlerMapping.add(requestMapping.value(), handler);
      }
    }
    beanContainer.put("handlerMapping", handlerMapping);
  }

  private Object callFactoryMethod(
      Object obj, 
      Method factoryMethod, 
      List<Method> factoryMethods,
      String indent) throws Exception {

    //    System.out.println(indent + "==>" + factoryMethod.getName());

    Class<?>[] paramTypes = factoryMethod.getParameterTypes();

    Object[] paramValues = new Object[paramTypes.length];

    for (int i = 0; i < paramTypes.length; i++) {
      Object paramValue = findBean(paramTypes[i]);
      if (paramValue != null) {
        paramValues[i] = paramValue;
        continue;
      }

      Method otherFactoryMethod = findMethodByReturnType(factoryMethods, paramTypes[i]);
      if (otherFactoryMethod == null) 
        return null;

      paramValue = callFactoryMethod(obj, otherFactoryMethod, factoryMethods, indent + "    ");
      if (paramValue == null) {
        return null;
      }
      paramValues[i] = paramValue;
    }
    factoryMethods.remove(factoryMethod);
    Object bean = factoryMethod.invoke(obj, paramValues);

    Bean beanAnno = factoryMethod.getAnnotation(Bean.class);
    beanContainer.put(
        beanAnno.value().length() > 0 ? beanAnno.value() : factoryMethod.getName(),
            bean);
    //    System.out.println(indent + "   : " + 
    //        bean.getClass().getSimpleName() + " 객체가 보관됨!");
    return bean;
  }

  private Method findMethodByReturnType(List<Method> methods, Class<?> returnType) {
    for (Method m : methods) {
      if (m.getReturnType() == returnType) {
        return m;
      }
    }
    return null;
  }

}










