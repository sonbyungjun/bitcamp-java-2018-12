package bitcamp.lms;

import java.text.SimpleDateFormat;
import java.util.Date;

class Board {
    int num;
    String content;
    int no;
    Date now = new Date();
    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
    String createdDate = format.format(now);

    public Board(int num, String content) {
      this.num = num;
      this.content = content;
    }
    public void print() {
      System.out.printf("%d, %-15s, %s, %4$d\n", num, content, createdDate, no);
  }
}
