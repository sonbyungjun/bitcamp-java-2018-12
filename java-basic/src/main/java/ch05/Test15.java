package ch05;

public class Test15 {
  public static void main(String[] args) {
    String[] names = {"홍길동", "임꺽정", "유관순", "안중근", "윤봉길", "김구"};
    
    for (String name : names) {
      System.out.print(name + " ");
    }
    System.out.println();
    
    java.util.ArrayList<String> list = new java.util.ArrayList<>();
    list.add("홍길동");
    list.add("임꺽정");
    list.add("유관순");
    
    for (String name : list) {
      System.out.print(name + " ");
    }
    System.out.println();
    
  }
}