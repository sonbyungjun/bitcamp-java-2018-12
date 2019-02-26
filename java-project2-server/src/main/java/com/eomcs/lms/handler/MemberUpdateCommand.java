package com.eomcs.lms.handler;
import com.eomcs.lms.dao.MemberDao;
import com.eomcs.lms.domain.Member;

public class MemberUpdateCommand extends AbstractCommand {

  MemberDao memberDao;

  public MemberUpdateCommand(MemberDao memberDao) {
    this.memberDao = memberDao;
  }

  @Override
  public void execute(Response response) throws Exception {
    int no = response.requestInt("번호?");

    Member member = memberDao.findByNo(no);
    if (member == null) {
      response.println("해당 회원을 찾지 못했습니다.");
      return;
    }
    // 기존 값 복제
    Member temp = member.clone();

    String input = response.requestString(String.format("이름(%s)?", member.getName()));
    if (input.length() > 0) 
      temp.setName(input);

    if ((input = response.requestString(
        String.format("이메일(%s)?", member.getEmail()))).length() > 0)
      temp.setEmail(input);

    while (true) {
      if ((input = response.requestString(
          "암호(암호는 반드시 입력하세요.)?")).length() < 2) {
        response.println("암호는 입력하셔야 합니다.");
        continue;
      }
      temp.setPassword(input);
      break;
    }

    if ((input = response.requestString(
        String.format("사진(%s)?", member.getPhoto()))).length() > 0)
      temp.setPhoto(input);

    if ((input = response.requestString(
        String.format("전화(%s)?", member.getTel()))).length() > 0)
      temp.setTel(input);

    memberDao.update(temp);
    response.println("회원을 변경했습니다.");

  }

}
