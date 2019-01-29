package design_pattern.command.after;

public class BoardListCommand implements Command {
  @Override
  public void execute() {
    System.out.println("게시물 목록조회 처리!");
  }
}
