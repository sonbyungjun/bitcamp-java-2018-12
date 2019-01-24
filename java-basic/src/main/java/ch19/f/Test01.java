package ch19.f;

public class Test01 {

  public static void main(String[] args) {
    LinkedList list = new LinkedList();
    list.add(100);
    list.add(200);
    list.add(300);
    list.add(400);
    list.add(500);
    list.add(600); 

    LinkedList list2 = new LinkedList();
    list2.add(10);
    list2.add(20);
    list2.add(30);
    list2.add(40);
    list2.add(50);
    list2.add(60); 

    Object[] arr = list.toArray(LinkedList.FORWARD);

    for(Object obj : arr) {
      System.out.print(obj + ",");
    }
    System.out.println();

    Object[] arr2 = list.toArray(LinkedList.REVERSE);

    for(Object obj : arr2) {
      System.out.print(obj + ",");
    }
    System.out.println();

    Object[] arr3 = list2.toArray(LinkedList.REVERSE);

    for(Object obj : arr3) {
      System.out.print(obj + ",");
    }
    System.out.println();
  }
}
