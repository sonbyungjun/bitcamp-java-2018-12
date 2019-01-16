package com.eomcs.lms.handler;

import java.sql.Date;
import java.util.Scanner;
import com.eomcs.lms.domain.Member;

public class MemberHandler {

  static final int LENGTH = 10;

  Scanner keyboard;
  Member[] members = new Member[LENGTH];
  int memberIdx = 0;

  public MemberHandler(Scanner keyboard) {
    this.keyboard = keyboard;
  }

  public void listMember() {
    for (int j = 0; j < memberIdx; j++) {
      System.out.printf("%3d, %-4s, %-20s, %-15s, %s\n", 
          this.members[j].getNo(), this.members[j].getName(), this.members[j].getEmail(), 
          this.members[j].getTel(), this.members[j].getRegisteredDate());
    }
  }

  public void addMember() {
    Member member = new Member();

    System.out.print("번호? ");
    member.setNo(Integer.parseInt(this.keyboard.nextLine()));

    System.out.print("이름? ");
    member.setName(this.keyboard.nextLine()); 

    System.out.print("이메일? ");
    member.setEmail(this.keyboard.nextLine());

    System.out.print("암호? ");
    member.setPassword(this.keyboard.nextLine());

    System.out.print("사진? ");
    member.setPhoto(this.keyboard.nextLine());

    System.out.print("전화? ");
    member.setTel(this.keyboard.nextLine());

    member.setRegisteredDate(new Date(System.currentTimeMillis())); 

    this.members[this.memberIdx] = member;
    this.memberIdx++;

    System.out.println("저장하였습니다.");
  }
}
