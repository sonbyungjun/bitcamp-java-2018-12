package ch22.a;

import java.io.File;

public class Test01 {
  
  public static void main(String[] args) throws Exception{
    File dir = new File("../../teacher/java-basic");
    System.out.println(dir.getName());
    System.out.println(dir.getPath());
    System.out.println(dir.getAbsolutePath());
    System.out.println(dir.getCanonicalPath());
    
    System.out.println(dir.getTotalSpace());
    System.out.println(dir.getFreeSpace());
    System.out.println(dir.getUsableSpace());
    
    System.out.println(dir.isDirectory());
    System.out.println(dir.isFile());
    System.out.println(dir.isHidden());
    System.out.println(dir.exists());
    System.out.println(dir.canExecute());
    System.out.println("----------------------------");
    
    File dir1 = new File(".");
    System.out.println(dir1.getName());
    System.out.println(dir1.getPath());
    System.out.println(dir1.getAbsolutePath());
    System.out.println(dir1.getCanonicalPath());
    
    System.out.println(dir1.getTotalSpace());
    System.out.println(dir1.getFreeSpace());
    System.out.println(dir1.getUsableSpace());
    
    System.out.println(dir1.isDirectory());
    System.out.println(dir1.isFile());
    System.out.println(dir1.isHidden());
    System.out.println(dir1.exists());
    System.out.println(dir1.canExecute());
  }

}
