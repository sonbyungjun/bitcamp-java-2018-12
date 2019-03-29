package com.eomcs.lms.service;

import java.util.List;
import com.eomcs.lms.domain.Member;

public interface MemberService {
  int add(Member member);
  List<Member> list(String keyword);
  Member get(int no);
  int update(Member member);
  int delete(int no);
}
