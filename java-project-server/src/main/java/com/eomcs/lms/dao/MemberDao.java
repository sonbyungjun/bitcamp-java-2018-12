package com.eomcs.lms.dao;

import java.util.List;
import com.eomcs.lms.domain.Member;

public class MemberDao extends AbstractDao<Member> {
  
  public MemberDao(String filepath) {
    this.filepath = filepath;
  }

  public void insert(Member member) {
    list.add(member);
  }

  public List<Member> findAll() {
    return list;
  }

  public Member findByNo(int no) {
    for (Member b : list) {
      if (b.getNo() == no) {
        return b;
      }
    }
    return null;
  }

  public int update(Member member) {
    int index = 0;
    for (Member m : list) {
      if (m.getNo() == member.getNo()) {
        list.set(index, member);
        return 1;
      }
      index++;
    }
    return 0;
  }

  public int delete(int no) {
    int index = 0;
    for (Member b : list) {
      if (b.getNo() == no) {
        list.remove(index);
        return 1;
      }
      index++;
    }
    return 0;
  }
}
