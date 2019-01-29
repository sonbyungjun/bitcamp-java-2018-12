package ch20.b;

import java.util.Stack;

public class Test01 {
  public static void main(String[] args) {
    Stack<String> stack = new Stack<>();
    
    stack.push("aaa");
    stack.push("bbb");
    stack.push("ccc");
    
    while (!stack.empty()) {
      System.out.println(stack.pop());
    }
  }
}
