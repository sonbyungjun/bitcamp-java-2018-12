package design_pattern.command.after;

public class MemberDeleteCommand implements Command {
  @Override
  public void execute() {
    System.out.println("회원 삭제 처리!");
  }
}
