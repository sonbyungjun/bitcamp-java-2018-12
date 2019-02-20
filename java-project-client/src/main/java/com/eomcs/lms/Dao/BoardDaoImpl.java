package com.eomcs.lms.Dao;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.List;
import com.eomcs.lms.domain.Board;

public class BoardDaoImpl implements BoardDao {

  public BoardDaoImpl() {
  }

  @SuppressWarnings("unchecked")
  public List<Board> findAll() {

    try (Socket socket = new Socket(this.serverAddr, this.port);
        ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
        ObjectInputStream in = new ObjectInputStream(socket.getInputStream());) {

      out.writeUTF(rootPath + "/list");
      out.flush();
      if (!in.readUTF().equals("OK"))
        throw new Exception("서버에서 해당 명령어를 처리하지 못합니다.");

      String status = in.readUTF();

      if (!status.equals("OK")) 
        throw new Exception("서버에서 게시글 목록 가져오기 실패!");

      return (List<Board>) in.readObject();
    } catch (Exception e) {
      throw new RuntimeException(e);
    }

  }

  public void insert(Board board) {

    try (Socket socket = new Socket(this.serverAddr, this.port);
        ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
        ObjectInputStream in = new ObjectInputStream(socket.getInputStream());) {

      out.writeUTF(rootPath + "/add");
      out.flush();
      if (!in.readUTF().equals("OK"))
        throw new Exception("서버에서 해당 명령어를 처리하지 못합니다.");

      out.writeObject(board);
      out.flush();

      String status = in.readUTF();

      if (!status.equals("OK"))
        throw new Exception("서버의 데이터 저장 실패!");
    } catch (Exception e) {
      throw new RuntimeException(e);
    }

  }

  public Board findByNo(int no) {

    try (Socket socket = new Socket(this.serverAddr, this.port);
        ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
        ObjectInputStream in = new ObjectInputStream(socket.getInputStream());) {

      out.writeUTF(rootPath + "/detail");
      out.flush();

      if (!in.readUTF().equals("OK"))
        throw new Exception("서버에서 해당 명령어를 처리하지 못합니다.");

      out.writeInt(no);
      out.flush();

      String status = in.readUTF();

      if (!status.equals("OK")) 
        throw new Exception("서버에서 게시글 가져오기 실패!");

      return (Board) in.readObject();
    } catch (Exception e) {
      throw new RuntimeException(e);
    }

  }

  public int update(Board board) {

    try (Socket socket = new Socket(this.serverAddr, this.port);
        ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
        ObjectInputStream in = new ObjectInputStream(socket.getInputStream());) {

      out.writeUTF(rootPath + "/update");
      out.flush();

      if (!in.readUTF().equals("OK"))
        throw new Exception("서버에서 해당 명령어를 처리하지 못합니다.");

      out.writeObject(board);
      out.flush();

      String status = in.readUTF();
      if (!status.equals("OK"))
        System.out.println("데이터 변경 실패!");

      return 1;
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
    
  }

  public int delete(int no) {

    try (Socket socket = new Socket(this.serverAddr, this.port);
        ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
        ObjectInputStream in = new ObjectInputStream(socket.getInputStream());) {

      out.writeUTF(rootPath + "/delete");
      out.flush();

      if (!in.readUTF().equals("OK"))
        throw new Exception("서버에서 해당 명령어를 처리하지 못합니다.");

      out.writeInt(no);
      out.flush();

      String status = in.readUTF();

      if (!status.equals("OK"))
        throw new Exception("서버에서 삭제 실패!");
      return 1;
    } catch (Exception e) {
      throw new RuntimeException(e);
    }

  }
}
