package ch22.a;

import java.io.File;
import java.io.FilenameFilter;

public class Test10_4 {

  public static void main(String[] args) throws Exception{

    File file = new File(".");

    String[] names = file.list((File dir, String name) -> {
      if (name.endsWith(".txt"))
        return true;
      else
        return false;
    });

    for (String name : names) {
      System.out.println(name);
    }

  }
}

