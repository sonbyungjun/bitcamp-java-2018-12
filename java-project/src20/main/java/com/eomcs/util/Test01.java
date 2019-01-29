package com.eomcs.util;

public class Test01 {
  public static void main(String[] args) {
    Queue3 list = new Queue3();
    list.offer(100);
    list.offer(200);
    list.offer(300);
    list.offer(400);
    list.offer(500);
    
    for (int i = 0; i < list.list.length; i++) {
      System.out.print(list.list[i] + ", ");
    }
    System.out.println();


    System.out.println(list.poll());
    for (int i = 0; i < list.list.length; i++) {
      System.out.print(list.list[i] + ", ");
    }
    System.out.println();
    System.out.println(list.poll());
    for (int i = 0; i < list.list.length; i++) {
      System.out.print(list.list[i] + ", ");
    }
    System.out.println();

    System.out.println(list.poll());
    for (int i = 0; i < list.list.length; i++) {
      System.out.print(list.list[i] + ", ");
    }
    System.out.println();

    System.out.println(list.poll());
    for (int i = 0; i < list.list.length; i++) {
      System.out.print(list.list[i] + ", ");
    }
    System.out.println();


  }
}
