package com.eomcs.lms.handler;
import java.sql.Date;
import java.util.Scanner;
import com.eomcs.lms.domain.Board;
import com.eomcs.lms.domain.Member;
import com.eomcs.util.ArrayList;

public class MemberHandler {

  Scanner keyboard;
  ArrayList<Member> list;

  public MemberHandler(Scanner keyboard) {
    this.keyboard = keyboard;
    this.list = new ArrayList<>(20);
  }

  public void listMember() {
    Member[] members = list.toArray(new Member[] {});
    for (Member member : members) {
      System.out.printf("%3d, %-4s, %-20s, %-15s, %s\n", 
          member.getNo(), member.getName(), 
          member.getEmail(), member.getTel(), member.getRegisteredDate());
    }
  }

  public void addMember() {
    Member member = new Member();

    System.out.print("번호? ");
    member.setNo(Integer.parseInt(keyboard.nextLine()));

    System.out.print("이름? ");
    member.setName(keyboard.nextLine());

    System.out.print("이메일? ");
    member.setEmail(keyboard.nextLine());

    System.out.print("암호? ");
    member.setPassword(keyboard.nextLine());

    System.out.print("사진? ");
    member.setPhoto(keyboard.nextLine());

    System.out.print("전화? ");
    member.setTel(keyboard.nextLine());

    member.setRegisteredDate(new Date(System.currentTimeMillis())); 

    list.add(member);

    System.out.println("저장하였습니다.");
  }

  public void datailBoard() {
    System.out.print("번호? ");
    int no = Integer.parseInt(keyboard.nextLine());
    int i = indexOfBoard(no);
    Member member = list.get(i);
    if (i == -1) {
      System.out.println("해당 학생을 찾을 수 없습니다.");
      return;
    }
    System.out.printf("이름: %s\n", member.getName());
    System.out.printf("이메일: %s\n", member.getEmail());
    System.out.printf("암호: %s\n", member.getPassword());
    System.out.printf("사진: %s\n", member.getPhoto());
    System.out.printf("전화: %s\n", member.getTel());
    System.out.printf("가입일: %s\n", member.getRegisteredDate());

  }

  public void updateBoard() {
    System.out.print("번호? ");
    int no = Integer.parseInt(keyboard.nextLine());
    int i = indexOfBoard(no);
    Member member = list.get(i);
    if (i == -1) {
      System.out.println("해당 회원을 찾을 수 없습니다.");
      return;
    }

    System.out.printf("이름(%s)? ", member.getName());
    String cmd = keyboard.nextLine();
    if (cmd.length() > 0)
      member.setName(cmd);

    System.out.printf("이메일(%s)? ", member.getEmail());
    if ((cmd = keyboard.nextLine()).length() > 0)
      member.setEmail(cmd);

    System.out.printf("암호(%s)? ", member.getPassword());
    if ((cmd = keyboard.nextLine()).length() > 0)
      member.setPassword(cmd);

    System.out.printf("사진(%s)? ", member.getPhoto());
    if ((cmd = keyboard.nextLine()).length() > 0)
      member.setPhoto(cmd);

    System.out.printf("전화(%s)? ", member.getTel());
    if ((cmd = keyboard.nextLine()).length() > 0)
      member.setTel(cmd);

    list.set(i, member);
    System.out.println("회원을 변경했습니다.");
  }

  public void deleteBoard() {
    System.out.print("번호? ");
    int no = Integer.parseInt(keyboard.nextLine());
    int i = indexOfBoard(no);
    if (i == -1) {
      System.out.println("해당 회원을 찾을 수 없습니다.");
      return;
    }
    list.delete(i);
    System.out.println("회원을 삭제했습니다.");
  }


  private int indexOfBoard(int index) {
    for (int i = 0; i < list.getSize(); i++) {
      Member member = list.get(i);
      if (member.getNo() == index)
        return i;
    }
    return -1;
  }

}
