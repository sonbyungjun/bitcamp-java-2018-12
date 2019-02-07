package design_pattern.composite;

public class Test01 {
  
  public static void main(String[] args) {
    Directory root = new Directory("/");
    
    root.add(new File("a.gif", "image/gif", 3456));
    root.add(new File("b.gif", "image/gif", 34530));
    root.add(new File("test.txt", "text/plain", 8700));
    
    Directory src = new Directory("/src");
    
    src.add(new File("Hello.java", "text/java", 320));
    src.add(new File("Hello2.java", "text/java", 400));
    root.add(src);
    
    Directory bitcamp = new Directory("/bitcamp");
    bitcamp.add(new File("A.java", "text/java", 200));
    src.add(bitcamp);
    
    display(root, "");
  }
  
  static void display(Directory dir, String path) {
    System.out.println(path);
    
    for (Node node : dir.childs) {
      if (node instanceof File) {
        System.out.printf("%s/%s\n", path, node.getTitle());
      } else if (node instanceof Directory) {
        display((Directory)node, path + node.getTitle());
      }
    }
  }
  
}
