package com.eomcs.lms.dao;

import java.util.List;
import com.eomcs.lms.domain.Member;

public interface MemberDao {
  public void insert(Member member);
  public List<Member> findAll();
  public List<Member> findByKeyword(String keyword);
  public Member findByNo(int no);
  public int update(Member member);
  public int delete(int no);
}
