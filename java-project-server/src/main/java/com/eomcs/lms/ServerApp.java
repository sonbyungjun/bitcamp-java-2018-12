package com.eomcs.lms;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import com.eomcs.lms.service.BoardService;
import com.eomcs.lms.service.LessonService;
import com.eomcs.lms.service.MemberService;

public class ServerApp {

  static ObjectInputStream in;
  static ObjectOutputStream out;

  static MemberService memberService = null;
  static LessonService lessonService = null;
  static BoardService boardService = null;

  public static void main(String[] args) {

    try (ServerSocket serverSocket = new ServerSocket(8888);) {
      System.out.println("서버 시작!");

      try {
        memberService = new MemberService();
        memberService.loadData("member.bin");
      } catch(Exception e) {
        System.out.println("데이터 로딩 중 오류 발생!");
      }
      try {
        lessonService = new LessonService();
        lessonService.loadData("lesson.bin");
      } catch(Exception e) {
        System.out.println("데이터 로딩 중 오류 발생!");
      }
      try {
        boardService = new BoardService();
        boardService.loadData("board.bin");
      } catch (Exception e) {
        System.out.println("데이터 로딩 중 오류 발생!");
      }

      while (true) {
        try (Socket socket = serverSocket.accept();
            ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
            ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream())) {
          
          boardService.init(in, out);
          memberService.init(in, out);
          lessonService.init(in, out);
          
          System.out.println("클라이언트와 연결되었음!");

          ServerApp.in = in;
          ServerApp.out = out;

          loop: while (true) {
            String request = in.readUTF();
            System.out.println(request);

            if (request.startsWith("/member/")) {
              memberService.execute(request);

            } else if (request.startsWith("/lesson/")) {
              lessonService.execute(request);

            } else if (request.startsWith("/board/")) {
              boardService.execute(request);

            } else if (request.equals("quit")) {
              quit();
              break loop;

            } else {
              out.writeUTF("FAIL");
            }
            out.flush();

          } // while (roop)

        } catch (Exception e) {
          e.printStackTrace();
        }
        System.out.println("클라이언트와 연결 끊었음!");

      } // while (server)

    } catch (Exception e) {
      e.printStackTrace();
    }

  }

  static void quit() throws Exception {
    try {
      boardService.saveData();
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
    try {
      memberService.saveData();
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
    try {
      lessonService.saveData();
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
    out.writeUTF("종료함!");
    out.flush();
  }

}
