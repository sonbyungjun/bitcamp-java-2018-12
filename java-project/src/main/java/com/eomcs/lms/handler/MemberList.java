package com.eomcs.lms.handler;

import com.eomcs.lms.domain.Member;

public class MemberList {
  
  private final int PRIMARYIDX = 10;
  private int idx = 0;
  private Member[] members;
  
  public MemberList() {
    this.members = new Member[PRIMARYIDX];
  }
  
  public MemberList(int index) {
    if (index > PRIMARYIDX)
      this.members = new Member[index];
  }
  
  
  public Member[] toArray() {
    Member[] b2 = new Member[this.idx];
    for (int i = 0; i < this.idx; i++) {
      b2[i] = this.members[i];
    }
    return b2;
  }
  
  public void add(Member member) {
    int oldIdx = idx;
    int newIdx = oldIdx + (oldIdx * 2);
    
    if (idx >= this.members.length) {
      Member[] b1 = new Member[newIdx];
      
      for (int i = 0; i < idx; i++) {
        b1[i] = members[i];
      }
      this.members = b1;
    }
    
    this.members[this.idx] = member;
    this.idx++;
    
  }
}
