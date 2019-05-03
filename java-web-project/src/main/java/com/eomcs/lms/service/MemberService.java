package com.eomcs.lms.service;

import java.util.List;
import com.eomcs.lms.domain.Member;

public interface MemberService {
  int add(Member member);
  List<Member> list(String keyword, int pageNo, int pageSize);
  Member get(int no);
  Member get(String email, String password);
  int update(Member member);
  int delete(int no);
  int size();
}
