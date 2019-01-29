package ch20.d;

import java.util.HashMap;

public class Test01 {
  public static void main(String[] args) {
    class Sudent {
      String name;
      int age;
      
      public Sudent(String name, int age) {
        this.name = name;
        this.age = age;
      }

      @Override
      public String toString() {
        return "Sudent [name=" + name + ", age=" + age + "]";
      }
    }
    
    HashMap<String, Sudent> map = new HashMap<>();
    
    map.put("aaa", new Sudent("홍길동", 20));
    map.put("bbb", new Sudent("임꺽정", 30));
    map.put("ccc", new Sudent("유관순", 16));
    map.put("ccc", new Sudent("안중근", 25));
    
    System.out.println(map.get("bbb"));
    
    String key1 = "bbb";
    String key2 = new String("bbb");
    System.out.println(key1 == key2);
    System.out.println(key1.hashCode() == key2.hashCode());
    System.out.println(key1.equals(key2));
    
    System.out.println(map.get(key2));
    
    System.out.println(map.get("ccc"));
  }
}
