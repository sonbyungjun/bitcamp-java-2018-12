package design_pattern.command.after;

public class BoardDetailCommand implements Command {
  @Override
  public void execute() {
    System.out.println("게시물 상세조회 처리!");
  }
}
