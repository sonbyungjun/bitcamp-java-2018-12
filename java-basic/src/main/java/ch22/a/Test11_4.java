package ch22.a;

import java.io.File;

public class Test11_4 {


  public static void main(String[] args) throws Exception{

    File file = new File(".");

    File[] files = file.listFiles((File pathname) -> {
      if (pathname.isFile() && pathname.getName().endsWith(".txt"))
        return true;
      else
        return false;
    });

    for (File f : files) {
      System.out.printf("%s %12d %s\n",
          f.isDirectory() ? "d" : "-",
              f.length(),
              f.getName());
    }

  }
}

