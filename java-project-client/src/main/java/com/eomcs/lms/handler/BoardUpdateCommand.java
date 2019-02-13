package com.eomcs.lms.handler;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;
import java.util.Scanner;
import com.eomcs.lms.domain.Board;

public class BoardUpdateCommand implements Command {

  Scanner keyboard;

  public BoardUpdateCommand(Scanner keyboard) {
    this.keyboard = keyboard;
  }

  @Override
  public void execute(ObjectInputStream in, ObjectOutputStream out) {
    
    System.out.print("번호? ");
    int no = Integer.parseInt(keyboard.nextLine());

    try {
      out.writeUTF("/board/update");
      out.flush();

      if (!in.readUTF().equals("OK"))
        throw new Exception("서버에서 해당 명령어를 처리하지 못합니다.");

      out.writeObject(board);
      out.flush();

      String status = in.readUTF();
      if (!status.equals("OK"))
        System.out.println("데이터 변경 실패!");

      // 기존 값 복제
      Board temp = board.clone();

      System.out.printf("내용? ");
      String input = keyboard.nextLine();
      if (input.length() > 0) 
        temp.setContents(input);

      list.set(index, temp);

      System.out.println("게시글을 변경했습니다.");

    } catch (Exception e) {
      System.out.println("변경 중 오류 발생!");
    }
  }

}
