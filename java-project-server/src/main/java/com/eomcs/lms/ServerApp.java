package com.eomcs.lms;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import com.eomcs.lms.dao.BoardDaoImpl;
import com.eomcs.lms.dao.LessonDaoImpl;
import com.eomcs.lms.dao.MemberDaoImpl;
import com.eomcs.lms.service.BoardDaoSkel;
import com.eomcs.lms.service.LessonDaoSkel;
import com.eomcs.lms.service.MemberDaoSkel;
import com.eomcs.lms.service.Service;

public class ServerApp {

  static BoardDaoImpl boardDao;
  static MemberDaoImpl memberDao;
  static LessonDaoImpl lessonDao;

  static HashMap<String, Service> serviceMap;
  static Set<String> serviceKeySet;
  
  static ExecutorService executorService = Executors.newCachedThreadPool();

  public static void main(String[] args) {

    try {
      boardDao = new BoardDaoImpl("board.bin");
      boardDao.loadData();
    } catch (Exception e) {
      System.out.println("데이터 로딩 중 오류 발생!");
    }

    try {
      memberDao = new MemberDaoImpl("member.bin");
      memberDao.loadData();
    } catch (Exception e) {
      System.out.println("데이터 로딩 중 오류 발생!");
    }

    try {
      lessonDao = new LessonDaoImpl("lesson.bin");
      lessonDao.loadData();
    } catch (Exception e) {
      System.out.println("데이터 로딩 중 오류 발생!");
    }

    serviceMap = new HashMap<>();
    serviceMap.put("/board/", new BoardDaoSkel(boardDao));
    serviceMap.put("/member/", new MemberDaoSkel(memberDao));
    serviceMap.put("/lesson/", new LessonDaoSkel(lessonDao));

    serviceKeySet = serviceMap.keySet();

    try (ServerSocket serverSocket = new ServerSocket(8888);) {
      System.out.println("서버 시작!");

      while (true) {
        
        executorService.submit(new RequestHandler(serverSocket.accept()));

      } // while (server)

    } catch (Exception e) {
      e.printStackTrace();
    }

  } // main()
  
  static class RequestHandler implements Runnable {

    static int count = 0;
    
    Socket socket;
    String name;

    public RequestHandler(Socket socket) {
      this.socket = socket;
      this.name = "핸들러-" + count++;
      System.out.printf("[%s : %s] 핸들러가 생성됨\n",
          Thread.currentThread().getName(), 
          this.getName());
    }
    
    public String getName() {
      return this.name;
    }

    @Override
    public void run() {
      try (Socket socket = this.socket;
          ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
          ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream())) {

        System.out.printf("[%s : %s] 클라이언트와 연결되었음.\n",
            Thread.currentThread().getName(), 
            this.getName());

        String request = in.readUTF();
        System.out.printf("[%s : %s] %s\n", 
            Thread.currentThread().getName(), this.getName(), request);

        Service service = getService(request);

        if (service == null) {
          out.writeUTF("FAIL");
        } else {
          service.execute(request, in, out);
        }
        out.flush();

      } catch (Exception e) {
        e.printStackTrace();
      }
      
      System.out.printf("[%s : %s] 클라이언트와 연결 끊었음.\n",
          Thread.currentThread().getName(), 
          this.getName());

    } // run()

  } // RequestProcessorThread class

  static Service getService(String request) {
    for (String key : serviceKeySet) {
      if (request.startsWith(key)) {
        return serviceMap.get(key);
      }
    }
    return null;
  }

}

