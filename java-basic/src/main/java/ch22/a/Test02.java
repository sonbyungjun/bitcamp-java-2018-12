package ch22.a;

import java.io.File;

public class Test02 {
  
  public static void main(String[] args) throws Exception{
    File file = new File("build.gradle");
    System.out.println(file.getName());
    System.out.println(file.getPath());
    System.out.println(file.getAbsolutePath());
    System.out.println(file.getCanonicalPath());
    
    System.out.println(file.getTotalSpace());
    System.out.println(file.getFreeSpace());
    System.out.println(file.getUsableSpace());
    System.out.println(file.length());
    
    System.out.println(file.isDirectory());
    System.out.println(file.isFile());
    System.out.println(file.isHidden());
    System.out.println(file.exists());
    System.out.println(file.canExecute());
    System.out.println("----------------------------");
    
    File dir1 = new File("build.grale2");
    System.out.println(dir1.getName());
    System.out.println(dir1.getPath());
    System.out.println(dir1.getAbsolutePath());
    System.out.println(dir1.getCanonicalPath());
    
    System.out.println(dir1.getTotalSpace());
    System.out.println(dir1.getFreeSpace());
    System.out.println(dir1.getUsableSpace());
    System.out.println(dir1.length());
    
    System.out.println(dir1.isDirectory());
    System.out.println(dir1.isFile());
    System.out.println(dir1.isHidden());
    System.out.println(dir1.exists());
    System.out.println(dir1.canExecute());
  }

}
