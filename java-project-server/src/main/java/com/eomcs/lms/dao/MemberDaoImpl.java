package com.eomcs.lms.dao;

import java.util.List;
import com.eomcs.lms.domain.Member;

public class MemberDaoImpl extends AbstractDao<Member> implements MemberDao {

  public MemberDaoImpl(String filepath) {
    this.filepath = filepath;
  }

  public void insert(Member member) {
    try {
      list.add(member);
      this.saveData();
    } catch(Exception e) {
      throw new RuntimeException(e);
    }
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
    try {
      int index = 0;
      for (Member m : list) {
        if (m.getNo() == member.getNo()) {
          list.set(index, member);
          this.saveData();
          return 1;
        }
        index++;
      }
      return 0;
    } catch(Exception e) {
      throw new RuntimeException(e);
    }
  }

  public int delete(int no) {
    try {
      int index = 0;
      for (Member b : list) {
        if (b.getNo() == no) {
          list.remove(index);
          this.saveData();
          return 1;
        }
        index++;
      }
      return 0;
    } catch(Exception e) {
      throw new RuntimeException(e);
    }
  }
}
