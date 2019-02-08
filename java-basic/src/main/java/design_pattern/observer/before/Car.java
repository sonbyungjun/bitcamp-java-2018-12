package design_pattern.observer.before;

public class Car {
  
  public void start() {
    System.out.println("시동을 건다.");
    
    System.out.println("안전벨트 착용 여부 검사");
    
    System.out.println("엔진 오일 유무 검사");
    
    System.out.println("브레이크 오일 유무 검사");
  }
  
  public void run() {
    System.out.println("달린다.");
  }
  
  public void stop() {
    System.out.println("시동을 끈다.");
    
    System.out.println("전조등을 끈다.");
    
    System.out.println("썬루프를 닫는다.");
  }
  
}
