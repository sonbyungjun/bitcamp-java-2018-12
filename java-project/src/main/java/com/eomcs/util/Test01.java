package com.eomcs.util;

public class Test01 {
  public static void main(String[] args) {
    Queue list = new Queue();
    list.offer(100);
    list.offer(200);
    list.offer(300);
    list.offer(400);
    list.offer(500);

    System.out.println(list.poll());
    System.out.println(list.poll());
    System.out.println(list.poll());
    System.out.println(list.poll());


  }
}
