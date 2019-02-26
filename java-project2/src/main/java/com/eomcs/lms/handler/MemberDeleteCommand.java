package com.eomcs.lms.handler;
import java.util.Scanner;
import com.eomcs.lms.dao.MemberDao;

public class MemberDeleteCommand implements Command {

  Scanner keyboard;
  MemberDao memberDao;

  public MemberDeleteCommand(Scanner keyboard, MemberDao memberDao) {
    this.keyboard = keyboard;
    this.memberDao = memberDao;
  }

  @Override
  public void execute() {
    System.out.print("번호? ");
    int no = Integer.parseInt(keyboard.nextLine());

    try {
      if (memberDao.delete(no) == 0) {
       System.out.println("해당 회원을 찾지 못했습니다.");
       return;
      }
      System.out.println("회원을 삭제했습니다.");

    } catch (Exception e) {
      System.out.printf("회원 삭제 오류! : %s\n", e.getMessage());
    }
  }

}
