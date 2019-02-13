package com.eomcs.lms;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ServerTest {

  static ObjectOutputStream out;
  static ObjectInputStream in;
  
  public static void main(String[] args) {

    try (Socket socket = new Socket("localhost", 8888);
        ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
        ObjectInputStream in = new ObjectInputStream(socket.getInputStream());) {

      System.out.println("서버와 연결되었음!");
      
      ServerTest.out = out;
      ServerTest.in = in;

      new MemberTest(out, in).test();
      System.out.println("-----------------------------------");
      
      new LessonTest(out, in).test();
      System.out.println("-----------------------------------");
      
      new BoardTest(out, in).test();
      System.out.println("-----------------------------------");
      
      quit();
      
      System.out.println("서버와와 연결 끊었음!");

    } catch (Exception e) {
      e.printStackTrace();

    }
  }
  
  static void quit() throws Exception {
    out.writeUTF("quit");
    out.flush();
    System.out.println(in.readUTF());
  }
}
