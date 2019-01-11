package bitcamp.lms;

import java.util.Date;

class Member {
  int num;
  String name;
  String email;
  String password;
  String photo;
  String tel;
  Date createdDate; 

  public Member(int num, String name, String email, String password, String photo, String tel) {
    this.num = num;
    this.name = name;
    this.email = email;
    this.password = password;
    this.photo = photo;
    this.tel = tel;
  }
  
  public void print() {
    System.out.printf("%d, %-4s, %-20s, %-15s, %5$tY-%5$tm-%5$td\n", num, name, email, tel, createdDate);
  }
  
}