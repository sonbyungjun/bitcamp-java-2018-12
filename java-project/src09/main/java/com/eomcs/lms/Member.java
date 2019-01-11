package com.eomcs.lms;

import java.sql.Date;
import java.util.Scanner;

public class Member {
  int no;
  String name;
  String email;
  String password;
  String photo;
  String tel;
  Date registeredDate;
  
  static Scanner keyboard = new Scanner(System.in);
  
  static Member addMember() {
    Member member = new Member();
    System.out.print("번호? ");
    member.no = Integer.parseInt(keyboard.nextLine());
    
    System.out.print("이름? ");
    member.name = keyboard.nextLine();
    
    System.out.print("이메일? ");
    member.email = keyboard.nextLine();
    
    System.out.print("암호? ");
    member.password = keyboard.nextLine();

    System.out.print("사진? ");
    member.photo = keyboard.nextLine();

    System.out.print("전화? ");
    member.tel = keyboard.nextLine();

    member.registeredDate = new Date(System.currentTimeMillis()); 
    
    return member;
  }
  
  static void listMember() {
    for (int j = 0; j < App.memberIdx; j++) {
      System.out.printf("%3d, %-4s, %-20s, %-15s, %s\n", 
          App.members[j].no, App.members[j].name, App.members[j].email, 
          App.members[j].tel, App.members[j].registeredDate);
    }
  }
  
}
