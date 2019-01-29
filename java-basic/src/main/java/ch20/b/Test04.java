package ch20.b;

import java.util.Stack;

public class Test04 {
  public static void main(String[] args) {
    Stack<String> stack = new Stack<>();
    
    stack.push("aaa");
    stack.push("bbb");
    stack.push("ccc");
    
    System.out.println(stack.search(new String("ccc")));
    System.out.println(stack.search(new String("bbb")));
    System.out.println(stack.search(new String("aaa")));
    System.out.println(stack.search(new String("xxx")));
    
  }
}
