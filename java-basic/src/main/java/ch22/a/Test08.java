package ch22.a;

import java.io.File;

public class Test08 {

  public static void main(String[] args) throws Exception{

    File file = new File(".");

    String[] names = file.list();
    for (String name : names) {
      System.out.println(name);
    }

  }
}

