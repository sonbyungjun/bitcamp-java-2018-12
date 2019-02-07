package ch22.a;

import java.io.File;

public class Test14 {

  public static void main(String[] args) throws Exception{

    File dir = new File("bin/main");

    findClass(dir, "");

  }

  static void findClass(File dir, String packageName) {
    File[] files = dir.listFiles(pathname ->
    pathname.isDirectory() ||
    (pathname.isFile() && pathname.getName().endsWith(".class")) ? true : false);
    
    for (File f : files) {
      if (f.isFile()) {
        System.out.printf("%s%s\n", packageName, f.getName().replace(".class", ""));
      } else {
        findClass(f, packageName + f.getName() + ".");
      }
      
    }
  }

}

