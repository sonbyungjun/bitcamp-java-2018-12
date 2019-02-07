package ch22.c;

import java.io.FileOutputStream;

public class Test03_3 {
  public static void main(String[] args) {

    
    try (FileOutputStream out = new FileOutputStream("data.bin");
        BufferedOutputStream out1 = new BufferedOutputStream(out);
        DataOutputStream out2 = new DataOutputStream(out1)) {
      
      
      int no = 200;
      String name = "ABC가각간갇갈";
      int age = 30;

      out2.writeInt(no);
      out2.writeUTF(name);
      out2.writeInt(age);
      out2.flush();
      
    } catch (Exception e) {
      e.printStackTrace();
      
    }
    
    System.out.println("출력 완료.");
      
    }
  }

