/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package bitcamp.lms;

public class App3 {
  public static void main(String[] args) {
    java.util.Scanner keyboard = new java.util.Scanner(System.in);

    System.out.print("번호? ");
    int num = keyboard.nextInt();
    keyboard.nextLine();

    System.out.print("내용? ");
    String content = keyboard.nextLine();
    
    java.util.Date dateCreated = new java.util.Date();
    
    int views = 0;
    
    System.out.println();
    System.out.printf("번호: %d\n", num);
    System.out.printf("내용: %s\n", content);
    System.out.printf("작성일: %1$tY-%1$tm-%1$td\n", dateCreated);
    System.out.printf("조회수: %d\n", views);
  }
}