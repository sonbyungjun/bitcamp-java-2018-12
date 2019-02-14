package com.eomcs.lms;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Set;
import com.eomcs.lms.dao.BoardDao;
import com.eomcs.lms.dao.LessonDao;
import com.eomcs.lms.dao.MemberDao;
import com.eomcs.lms.service.BoardService;
import com.eomcs.lms.service.LessonService;
import com.eomcs.lms.service.MemberService;
import com.eomcs.lms.service.Service;

public class ServerApp {

  static BoardDao boardDao = null;
  static MemberDao memberDao = null;
  static LessonDao lessonDao = null;

  public static void main(String[] args) {

    try {
      boardDao = new BoardDao("board.bin");
      boardDao.loadData();
    } catch (Exception e) {
      System.out.println("데이터 로딩 중 오류 발생!");
    }

    try {
      memberDao = new MemberDao("member.bin");
      memberDao.loadData();
    } catch (Exception e) {
      System.out.println("데이터 로딩 중 오류 발생!");
    }

    try {
      lessonDao = new LessonDao("lesson.bin");
      lessonDao.loadData();
    } catch (Exception e) {
      System.out.println("데이터 로딩 중 오류 발생!");
    }

    HashMap<String, Service> serviceMap = new HashMap<>();
    serviceMap.put("/board/", new BoardService(boardDao));
    serviceMap.put("/member/", new MemberService(memberDao));
    serviceMap.put("/lesson/", new LessonService(lessonDao));

    Set<String> keySet = serviceMap.keySet();

    try (ServerSocket serverSocket = new ServerSocket(8888);) {
      System.out.println("서버 시작!");

      while (true) {
        try (Socket socket = serverSocket.accept();
            ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
            ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream())) {

          System.out.println("클라이언트와 연결되었음!");

          String request = in.readUTF();
          System.out.println(request);

          if (request.equals("quit")) {
            quit(in, out);
            out.flush();
            continue;
           }

          String serviceName = null;
          for (String key : keySet) {
            if (request.startsWith(key)) {
              serviceName = key;
              break;
              }
           }

          if (serviceName == null) {
            out.writeUTF("FAIL");

          } else {
            serviceMap.get(serviceName).execute(request, in, out);
           }
          
          out.flush();

        } catch (Exception e) {
          e.printStackTrace();
        }
        System.out.println("클라이언트와 연결 끊었음!");

      } // while (server)

    } catch (Exception e) {
      e.printStackTrace();
    }

  }

  static void quit(ObjectInputStream in, ObjectOutputStream out) throws Exception {

    try {
      boardDao.saveData();
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }

    try {
      memberDao.saveData();
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }

    try {
      lessonDao.saveData();
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
    out.writeUTF("종료함!");
  }

}
