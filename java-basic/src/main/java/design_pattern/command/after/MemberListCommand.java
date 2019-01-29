package design_pattern.command.after;

public class MemberListCommand implements Command {
  @Override
  public void execute() {
    System.out.println("회원 목록조회 처리!");
  }
}
