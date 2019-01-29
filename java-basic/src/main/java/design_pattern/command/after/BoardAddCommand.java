package design_pattern.command.after;

public class BoardAddCommand implements Command {
  @Override
  public void execute() {
    System.out.println("게시물 입력 처리!");
  }
}
