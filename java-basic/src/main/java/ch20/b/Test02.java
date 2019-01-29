package ch20.b;

import java.util.Stack;

public class Test02 {
  public static void main(String[] args) {
    Stack<String> stack = new Stack<>();
    
    stack.push("aaa");
    stack.push("bbb");
    stack.push("ccc");
    
    System.out.println(stack.pop());
    System.out.println(stack.pop());
    System.out.println(stack.pop());
    System.out.println(stack.pop());
    
  }
}
